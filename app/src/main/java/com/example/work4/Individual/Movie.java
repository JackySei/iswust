package com.example.work4.Individual;

public class Movie {
    public int img;
    String name;
    String data;
    String director;

    public Movie(int img,String name, String data, String director) {
        this.img =img;
        this.name = name;
        this.data = data;
        this.director = director;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
