package com.weatherdesigndemo;

public class Game {

    int imagesource;
    String name;

    public Game (int imageSource, String name) {
        this.name = name;
        this.imagesource = imageSource;
    }

    public int getImagesource() {
        return imagesource;
    }

    public void setImagesource(int imagesource) {
        this.imagesource = imagesource;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
