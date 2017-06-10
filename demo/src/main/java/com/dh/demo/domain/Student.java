package com.dh.demo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author rOlguin
 */
@Document
public class Student {
    @Id
    private String id;
    private String name;
    private Long ci;
    private Long codeSis;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCi(Long ci) {
        this.ci = ci;
    }

    public void setCodeSis(Long codeSis) {
        this.codeSis = codeSis;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getCi() {
        return ci;
    }

    public Long getCodeSis() {
        return codeSis;
    }
}

