package org.jk.utils;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.jk.model.Planet;

public class JSONParser {
    public static <T> T parseJSONToObject(String jsonString, Class<T> clazz) {
        DocumentContext json = JsonPath.parse(jsonString);
        return switch (clazz.getSimpleName()) {
            case "Planet" -> (T) new Planet().parse(json);
            default -> throw new IllegalArgumentException("Unknown class type: " + clazz.getSimpleName());
        };
    }
}