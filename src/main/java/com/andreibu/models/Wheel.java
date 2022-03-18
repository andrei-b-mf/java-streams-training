package com.andreibu.models;

public class Wheel {
    public final int width;
    public final int aspectRatio;
    public final int rimDiameter;

    public Wheel(int width, int aspectRatio, int rimDiameter) {
        this.width = width;
        this.aspectRatio = aspectRatio;
        this.rimDiameter = rimDiameter;
    }

    @Override
    public String toString() {
        return "Wheel{" +
                "width=" + width +
                ", aspectRatio=" + aspectRatio +
                ", rimDiameter=" + rimDiameter +
                '}';
    }
}
