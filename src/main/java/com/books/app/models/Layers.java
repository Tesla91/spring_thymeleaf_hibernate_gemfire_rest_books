package com.books.app.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Layers {

    String layerId;
    String volumeAnnotationsVersion;

    public Layers() {
    }

    public Layers(String layerId, String volumeAnnotationsVersion) {
        this.layerId = layerId;
        this.volumeAnnotationsVersion = volumeAnnotationsVersion;
    }

    public String getLayerId() {
        return layerId;
    }

    public void setLayerId(String layerId) {
        this.layerId = layerId;
    }

    public String getVolumeAnnotationsVersion() {
        return volumeAnnotationsVersion;
    }

    public void setVolumeAnnotationsVersion(String volumeAnnotationsVersion) {
        this.volumeAnnotationsVersion = volumeAnnotationsVersion;
    }
}
