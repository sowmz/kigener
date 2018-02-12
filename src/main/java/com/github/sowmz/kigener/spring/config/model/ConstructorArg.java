package com.github.sowmz.kigener.spring.config.model;

import javax.xml.bind.annotation.XmlAttribute;

public class ConstructorArg {
    String value;

    String ref;

    @XmlAttribute
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @XmlAttribute
    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }
}
