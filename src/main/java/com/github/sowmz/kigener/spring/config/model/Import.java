package com.github.sowmz.kigener.spring.config.model;

import javax.xml.bind.annotation.XmlAttribute;

public class Import {

    String resource;

    @XmlAttribute
    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }
}
