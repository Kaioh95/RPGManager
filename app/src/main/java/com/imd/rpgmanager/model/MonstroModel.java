package com.imd.rpgmanager.model;

import android.widget.TextView;

public class MonstroModel {

    private String name;
    private String type;
    private String hit_points;
    private String challenge_rating;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHit_points() {
        return hit_points;
    }

    public void setHit_points(String hit_points) {
        this.hit_points = hit_points;
    }

    public String getChallenge_rating() {
        return challenge_rating;
    }

    public void setChallenge_rating(String challenge_rating) {
        this.challenge_rating = challenge_rating;
    }

}
