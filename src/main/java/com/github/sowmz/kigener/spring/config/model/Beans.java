package com.github.sowmz.kigener.spring.config.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Beans {
    List<Import> importList;

    List<Bean> beanList;

    @XmlElement(name="import")
    public List<Import> getImportList() {
        return importList;
    }

    public void setImportList(List<Import> importList) {
        this.importList = importList;
    }

    @XmlElement(name="bean")
    public List<Bean> getBeanList() {
        return beanList;
    }

    public void setBeanList(List<Bean> beanList) {
        this.beanList = beanList;
    }
}
