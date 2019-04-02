package com.ryx.common;
public class BaseEntity {

    private int page;
    private int rows;
    private int beginRows;
    private int endRows;


    public int getBeginRows() {
        return beginRows;
    }

    public void setBeginRows(int beginRows) {
        this.beginRows = beginRows;
    }

    public int getEndRows() {
        return endRows;
    }

    public void setEndRows(int endRows) {
        this.endRows = endRows;
    }

    public int getBegin(){
        return (this.page-1)*rows;
    }

    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        this.page = page;
    }
    public int getRows() {
        return rows;
    }
    public void setRows(int rows) {
        this.rows = rows;
    }







}
