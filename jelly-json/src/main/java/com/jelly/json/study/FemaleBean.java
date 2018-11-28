package com.jelly.json.study;

public class FemaleBean {
    private int id;
    private String nick;

    @Override
    public String toString() {
        return "FemaleBean{" +
                "id=" + id +
                ", nick='" + nick + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }
}
