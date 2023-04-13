package org.jk;

import io.qameta.allure.testng.AllureTestNg;
import org.assertj.core.api.Assertions;
import org.jk.client.APIClient;
import org.jk.utils.JSONParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.jayway.jsonpath.JsonPath;
import org.jk.model.Planet;

import static org.assertj.core.api.Assertions.assertThat;

@Listeners({AllureTestNg.class})
public class PlanetTest {
    private final APIClient apiClient = new APIClient();

    @Test
    public void testGetAllPlanets() {
        int expectedCount = 60;
        ResponseEntity<String> response = apiClient.getAllPlanets();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        int actualCount = JsonPath.parse(response.getBody()).read("$.count");
        assertThat(actualCount).isEqualTo(expectedCount);
    }

    @Test
    public void testGetPlanetDetails() {
        ResponseEntity<String> response = apiClient.getPlanetById(1);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        Planet expectedPlanet = JSONParser.parseJSONToObject(response.getBody(), Planet.class);

        Assertions.assertThat(expectedPlanet.getName()).isEqualTo("Tatooine");
        Assertions.assertThat(expectedPlanet.getRotationPeriod()).isEqualTo("23");
        Assertions.assertThat(expectedPlanet.getOrbitalPeriod()).isEqualTo("304");
        Assertions.assertThat(expectedPlanet.getDiameter()).isEqualTo(10465);
        Assertions.assertThat(expectedPlanet.getClimate()).isEqualTo("arid");
        Assertions.assertThat(expectedPlanet.getGravity()).isEqualTo("1 standard");
        Assertions.assertThat(expectedPlanet.getTerrain()).isEqualTo("desert");
        Assertions.assertThat(expectedPlanet.getSurfaceWater()).isEqualTo("1");
        Assertions.assertThat(expectedPlanet.getPopulation()).isEqualTo("200000");
    }
}
