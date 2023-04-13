package org.jk.model;

import com.jayway.jsonpath.DocumentContext;

public class Person {
    private String name;
    private int height;
    private int mass;
    private String hairColor;
    private String skinColor;
    private String eyeColor;
    private String birthYear;
    private String gender;

    // Constructor
    public Person() {}

    public static Person parse(DocumentContext json) {
        Person planet = new Person();
        planet.setName(json.read("$.name"));
        planet.setHeight(Integer.parseInt(json.read("$.height")));
        planet.setHairColor(json.read("$.hair_color"));
        planet.setSkinColor(json.read("$.skin_color"));
        planet.setBirthYear(json.read("$.birth_year"));
        planet.setEyeColor(json.read("$.eye_color"));
        planet.setGender(json.read("$.gender"));
        planet.setMass(Integer.parseInt(json.read("$.mass")));
        return planet;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public int getMass() {
        return mass;
    }

    public String getHairColor() {
        return hairColor;
    }

    public String getSkinColor() {
        return skinColor;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public String getGender() {
        return gender;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public void setSkinColor(String skinColor) {
        this.skinColor = skinColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}