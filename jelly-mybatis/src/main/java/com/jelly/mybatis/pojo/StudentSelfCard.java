package com.jelly.mybatis.pojo;

import java.util.Date;

public class StudentSelfCard {
    private int studentSelfCardId;
    private int studentId;
    private String _native;
    private  Date issueDate;
    private Date endDate;
    private String note;

    public int getStudentSelfCardId() {
        return studentSelfCardId;
    }

    public void setStudentSelfCardId(int studentSelfCardId) {
        this.studentSelfCardId = studentSelfCardId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String get_native() {
        return _native;
    }

    public void set_native(String _native) {
        this._native = _native;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "StudentSelfCard{" +
                "studentSelfCardId=" + studentSelfCardId +
                ", studentId=" + studentId +
                ", _native='" + _native + '\'' +
                ", issueDate=" + issueDate +
                ", endDate=" + endDate +
                ", note='" + note + '\'' +
                '}';
    }
}
