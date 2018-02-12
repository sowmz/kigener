package com.github.sowmz.kigener.spring.config.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class Bean {

    String name;

    String className;

    String id;

    List<Property> propertyList;

    List<ConstructorArg> constructorArgList;

    @XmlAttribute
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlAttribute(name="class")
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @XmlAttribute
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @XmlElement(name="property")
    public List<Property> getPropertyList() {
        return propertyList;
    }

    public void setPropertyList(List<Property> propertyList) {
        this.propertyList = propertyList;
    }

    @XmlElement(name="constructor-arg")
    public List<ConstructorArg> getConstructorArgList() {
        return constructorArgList;
    }

    public void setConstructorArgList(List<ConstructorArg> constructorArgList) {
        this.constructorArgList = constructorArgList;
    }
}
