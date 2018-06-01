package com.teda.practiceempresarial.model;

import java.io.Serializable;

/**
 * Created by anime on 30/05/2018.
 */

public class Element implements Serializable {
    private Distance distance;
    private Duration duration;
    private String status;

    public Distance getDistance() {
        return distance;
    }

    public void setDistance(Distance distance) {
        this.distance = distance;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
