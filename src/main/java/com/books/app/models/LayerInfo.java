package com.books.app.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class LayerInfo {

    Layers[] layers;

    public LayerInfo() {
    }

    public LayerInfo(Layers[] layers) {
        this.layers = layers;
    }

    public Layers[] getLayers() {
        return layers;
    }

    public void setLayers(Layers[] layers) {
        this.layers = layers;
    }
}
