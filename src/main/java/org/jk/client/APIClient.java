package org.jk.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class APIClient {

    @Autowired
    private RestTemplate restTemplate = new RestTemplate();

    private static final String BASE_URL = "https://swapi.dev/api/";

    public String getBaseUrl() {
        return BASE_URL;
    }
    public ResponseEntity<String> getAllPlanets() {
        return restTemplate.getForEntity(BASE_URL + "planets", String.class);
    }

    public ResponseEntity<String> getPlanetById(int planetId) {
        return restTemplate.getForEntity(BASE_URL + "planets/" + planetId, String.class);
    }
}