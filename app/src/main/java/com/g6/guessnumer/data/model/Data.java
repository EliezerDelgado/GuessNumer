package com.g6.guessnumer.data.model;

import java.io.Serializable;

public class Data implements Serializable {
    private String user;
    private Integer attempts;
    private String state="";
    private Integer numRand;

    @Override
    public String toString() {
        return "Data{" +
                "user='" + user + '\'' +
                ", intention='" + attempts + '\'' +
                ", state='" + state + '\'' +
                ", numRand='" + numRand + '\'' +
                '}';
    }
    public Data(String user, Integer intention,String estado, Integer numRand) {
        this.user = user;
        this.attempts = intention;
        this.state = estado;
        this.numRand = numRand;
    }

    public Integer getNumRand() {
        return numRand;
    }

    public void setNumRand(Integer numRand) {
        this.numRand = numRand;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Data() {
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Integer getAttempts() {
        return attempts;
    }

    public void setAttempts(Integer attempts) {
        this.attempts = attempts;
    }
}
