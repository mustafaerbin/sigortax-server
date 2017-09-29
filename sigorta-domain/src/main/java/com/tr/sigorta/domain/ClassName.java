package com.tr.sigorta.domain;

import com.tr.nebula.persistence.jpa.domain.BaseEntity;

import javax.persistence.Entity;


/**
 * Created by Mustafa Erbin on 16/09/2017.
 * Genel tipler, sigorta tipi, sigorta şirketi vs..
 */
@Entity
public class ClassName extends BaseEntity {

    private String name;
    private String code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
