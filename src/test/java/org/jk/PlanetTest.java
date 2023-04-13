package org.jk;

import io.qameta.allure.testng.AllureTestNg;
import org.assertj.core.api.Assertions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.testng.annotations.Listeners;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.Test;
import com.jayway.jsonpath.JsonPath;

import static org.assertj.core.api.Assertions.assertThat;

@Listeners({AllureTestNg.class})
public class PlanetTest {

    private final RestTemplate restTemplate = new RestTemplate();
    String baseUrl = "https://swapi.dev/api/planets/";

    @Test
    public void testGetAllPlanets() {
        int expectedCount = 60;
        String responseBody = restTemplate.getForObject(baseUrl, String.class);
        int actualCount = JsonPath.parse(responseBody).read("$.count");
        assertThat(actualCount).isEqualTo(expectedCount);
    }

    @Test
    public void testGetPlanetDetails() {
        String url = baseUrl + "1";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        Planet planet = Planet.fromJson(response.getBody());

        Assertions.assertThat(planet.getName()).isEqualTo("Tatooine");
        Assertions.assertThat(planet.getRotationPeriod()).isEqualTo("23");
        Assertions.assertThat(planet.getOrbitalPeriod()).isEqualTo("304");
        Assertions.assertThat(planet.getDiameter()).isEqualTo(10465);
        Assertions.assertThat(planet.getClimate()).isEqualTo("arid");
        Assertions.assertThat(planet.getGravity()).isEqualTo("1 standard");
        Assertions.assertThat(planet.getTerrain()).isEqualTo("desert");
        Assertions.assertThat(planet.getSurfaceWater()).isEqualTo("1");
        Assertions.assertThat(planet.getPopulation()).isEqualTo("200000");
    }
}
