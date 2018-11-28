package com.jelly.mybatis.pojo;

import com.jelly.mybatis.type.Sex;

import java.util.List;

public class Student {
    private int studentId;
    private String cnname;
    private Sex sex;
    private String note;
    private StudentSelfCard studentSelfCard;

    public List<StudentLectureBean> getStudentLectures() {
        return studentLectures;
    }

    public void setStudentLectures(List<StudentLectureBean> studentLectures) {
        this.studentLectures = studentLectures;
    }

    private List<StudentLectureBean> studentLectures;
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getCnname() {
        return cnname;
    }

    public void setCnname(String cnname) {
        this.cnname = cnname;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public StudentSelfCard getStudentSelfCard() {
        return studentSelfCard;
    }

    public void setStudentSelfCard(StudentSelfCard studentSelfCard) {
        this.studentSelfCard = studentSelfCard;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", cnname='" + cnname + '\'' +
                ", sex=" + sex +
                ", note='" + note + '\'' +
                ", studentSelfCard=" + studentSelfCard +
                '}';
    }
}
