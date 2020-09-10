package com.nandwere.gadsmobileapplication.model;

import com.google.gson.annotations.SerializedName;

public class SkillIQLeader {
    public String name;
    public String country;
    public String score;

    public SkillIQLeader() {

    }

    public SkillIQLeader(String name, String country, String score) {
        this.name = name;
        this.country = country;
        this.score = score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getScore() {
        return score;
    }
}
