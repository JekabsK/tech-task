package org.jk.model;

import com.jayway.jsonpath.DocumentContext;

public class Planet {
    private String name;
    private String rotationPeriod;
    private String orbitalPeriod;
    private Long diameter;
    private String climate;
    private String gravity;
    private String terrain;
    private String surfaceWater;
    private String population;

    public static Planet parse(DocumentContext json) {
        Planet planet = new Planet();
        planet.setName(json.read("$.name"));
        planet.setRotationPeriod(json.read("$.rotation_period"));
        planet.setOrbitalPeriod(json.read("$.orbital_period"));
        planet.setDiameter((Long.valueOf(json.read("$.diameter"))));
        planet.setClimate(json.read("$.climate"));
        planet.setGravity(json.read("$.gravity"));
        planet.setTerrain(json.read("$.terrain"));
        planet.setSurfaceWater(json.read("$.surface_water"));
        planet.setPopulation(json.read("$.population"));
        return planet;
    }

    // getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getGravity() {
        return gravity;
    }

    public void setGravity(String gravity) {
        this.gravity = gravity;
    }

    public void setSurfaceWater(String surfaceWater) {
        this.surfaceWater = surfaceWater;
    }

    public void setOrbitalPeriod(String orbitalPeriod) {
        this.orbitalPeriod = orbitalPeriod;
    }

    public void setDiameter(Long diameter) {
        this.diameter = diameter;
    }

    public void setRotationPeriod(String rotationPeriod) {
        this.rotationPeriod = rotationPeriod;
    }

    public String getRotationPeriod() {
        return this.rotationPeriod;
    }

    public String getOrbitalPeriod() {
        return this.orbitalPeriod;
    }

    public Long getDiameter() {
        return this.diameter;
    }

    public String getSurfaceWater() {
        return surfaceWater;
    }
}