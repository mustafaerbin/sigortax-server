package com.tr.sigorta.domain;

import com.tr.nebula.persistence.jpa.domain.BaseEntity;

import javax.persistence.Entity;


/**
 * Created by Mustafa Erbin on 16/09/2017.
 * Sigorta acentesi.
 */
@Entity
public class Company extends BaseEntity {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
