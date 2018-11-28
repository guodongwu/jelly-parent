package com.jelly.mybatis.type;

public enum  Sex {
    FEMALE(0,"女"),MALE(1,"男"),;
    private int id;
    private  String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private  Sex(int id, String  name){
        this.id=id;
        this.name=name;
    }

    public  static  Sex getSex(int id){
        if(id==0){
            return FEMALE;
        }
        else if(id==1){
            return  MALE;
        }
        return null;
    }

}
