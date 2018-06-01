package com.teda.practiceempresarial.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by anime on 30/05/2018.
 */

public class Row implements Serializable {
    private List<Element> elements;

    public List<Element> getElements() {
        return elements;
    }

    public void setElements(List<Element> elements) {
        this.elements = elements;
    }
}
