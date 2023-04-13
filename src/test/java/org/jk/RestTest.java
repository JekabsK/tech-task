package org.jk;

import io.qameta.allure.testng.AllureTestNg;
import org.testng.annotations.Listeners;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.Test;
import com.jayway.jsonpath.JsonPath;
import static org.assertj.core.api.Assertions.assertThat;

@Listeners({AllureTestNg.class})
public class RestTest {

    private RestTemplate restTemplate = new RestTemplate();
    String baseUrl = "https://swapi.dev/api";

    @Test
    public void testGetRequest() {
        String url = baseUrl + "/planets";
        int expectedCount = 60;
        String responseBody = restTemplate.getForObject(url, String.class);
        int actualCount = JsonPath.parse(responseBody).read("$.count");
        assertThat(actualCount).isEqualTo(expectedCount);
    }
}
