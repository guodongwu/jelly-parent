package com.jelly.mybatis.pojo;

public class LectureBean {
    private  Integer id;
    private String lectureName;

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "LectureBean{" +
                "id=" + id +
                ", lectureName='" + lectureName + '\'' +
                ", note='" + note + '\'' +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLectureName() {
        return lectureName;
    }

    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    private  String note;
}
