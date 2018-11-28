package com.jelly.mybatis.mysql.pojo;

public class Column {
    private  String column_name;
    private String column_type;
    private int column_length;
    private String column_comment;
    private String column_key;
    private boolean auto_identity;

    public String getColumn_key() {
        return column_key;
    }

    public void setColumn_key(String column_key) {
        this.column_key = column_key;
    }

    public String getColumn_name() {
        return column_name;
    }

    public void setColumn_name(String column_name) {
        this.column_name = column_name;
    }

    public String getColumn_type() {
        return column_type;
    }

    public void setColumn_type(String column_type) {
        this.column_type = column_type;
    }

    public int getColumn_length() {
        return column_length;
    }

    public void setColumn_length(int column_length) {
        this.column_length = column_length;
    }

    public String getColumn_comment() {
        return column_comment;
    }

    public void setColumn_comment(String column_comment) {
        this.column_comment = column_comment;
    }



    public boolean isAuto_identity() {
        return auto_identity;
    }

    public void setAuto_identity(boolean auto_identity) {
        this.auto_identity = auto_identity;
    }
}
