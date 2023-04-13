package org.jk;

import io.qameta.allure.testng.AllureTestNg;
import org.assertj.core.api.SoftAssertions;
import org.jk.client.APIClient;
import org.jk.model.Person;
import org.jk.utils.JSONParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Listeners({AllureTestNg.class})
public class PeopleTest {
    private final APIClient apiClient = new APIClient();

    @Test
    public void testGetSinglePerson() {

        ResponseEntity<String> response = apiClient.getPersonById(1);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Person actualPerson = JSONParser.parseJSONToObject(response.getBody(), Person.class);

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(actualPerson.getName()).as("Name").isEqualTo("Luke Skywalker");
        softly.assertThat(actualPerson.getHeight()).as("Height").isEqualTo(172);
        softly.assertThat(actualPerson.getMass()).as("Mass").isEqualTo(77);
        softly.assertThat(actualPerson.getHairColor()).as("Hair color").isEqualTo("blond");
        softly.assertThat(actualPerson.getSkinColor()).as("Skin color").isEqualTo("fair");
        softly.assertThat(actualPerson.getEyeColor()).as("Eye color").isEqualTo("blue");
        softly.assertThat(actualPerson.getBirthYear()).as("Birth year").isEqualTo("19BBY");
        softly.assertThat(actualPerson.getGender()).as("Gender").isEqualTo("male");
        softly.assertAll();
    }
}
