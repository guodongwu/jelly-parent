package com.ryx.ryxrzt.entity;

import java.io.Serializable;

public class RztAgencyFreezeLs implements Serializable{
    private String id;

    private String freeze;

    private String freezeRelation;

    private String freezePerson;

    private String indate;

    private String note;

    private String freezedPerson;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getFreeze() {
        return freeze;
    }

    public void setFreeze(String freeze) {
        this.freeze = freeze == null ? null : freeze.trim();
    }

    public String getFreezeRelation() {
        return freezeRelation;
    }

    public void setFreezeRelation(String freezeRelation) {
        this.freezeRelation = freezeRelation == null ? null : freezeRelation.trim();
    }

    public String getFreezePerson() {
        return freezePerson;
    }

    public void setFreezePerson(String freezePerson) {
        this.freezePerson = freezePerson == null ? null : freezePerson.trim();
    }

    public String getIndate() {
        return indate;
    }

    public void setIndate(String indate) {
        this.indate = indate == null ? null : indate.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public String getFreezedPerson() {
        return freezedPerson;
    }

    public void setFreezedPerson(String freezedPerson) {
        this.freezedPerson = freezedPerson == null ? null : freezedPerson.trim();
    }
}