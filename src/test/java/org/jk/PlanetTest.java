package org.jk;

import io.qameta.allure.testng.AllureTestNg;
import org.assertj.core.api.SoftAssertions;
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
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(expectedPlanet.getName()).isEqualTo("Tatooine");
        softly.assertThat(expectedPlanet.getRotationPeriod()).isEqualTo("23");
        softly.assertThat(expectedPlanet.getOrbitalPeriod()).isEqualTo("304");
        softly.assertThat(expectedPlanet.getDiameter()).isEqualTo(10465);
        softly.assertThat(expectedPlanet.getClimate()).isEqualTo("arid");
        softly.assertThat(expectedPlanet.getGravity()).isEqualTo("1 standard");
        softly.assertThat(expectedPlanet.getTerrain()).isEqualTo("desert");
        softly.assertThat(expectedPlanet.getSurfaceWater()).isEqualTo("1");
        softly.assertThat(expectedPlanet.getPopulation()).isEqualTo("200000");
        softly.assertAll();
    }
}
