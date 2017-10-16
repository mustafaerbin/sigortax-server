package com.tr.sigorta.domain;

import com.tr.nebula.persistence.jpa.domain.BaseEntity;

import javax.persistence.Entity;

/**
 * Created by Mustafa Erbin on 12/10/2017.
 */
@Entity
public class JobControl extends BaseEntity {

    private boolean status;
    private String cron;
    private String description;
    private String code;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
