package com.teda.practiceempresarial.model;

import java.io.Serializable;

/**
 * Created by anime on 30/05/2018.
 */

public class Distance implements Serializable {

    private String text;
    private int value;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
