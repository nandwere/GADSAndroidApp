package com.nandwere.gadsmobileapplication.model;

public class LearningLeader {
    public String name;
    public String country;
    public String hours;

    public LearningLeader() {
    }

    public LearningLeader(String name, String country, String hours) {
        this.name = name;
        this.country = country;
        this.hours = hours;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getHours() {
        return hours;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }
}
