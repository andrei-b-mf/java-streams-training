package com.andreibu.models;

import com.andreibu.util.IdGenerator;

public class Wheel {
    public final int id;
    public final int width;
    public final int aspectRatio;
    public final int rimDiameter;

    public Wheel(int width, int aspectRatio, int rimDiameter) {
        id = IdGenerator.getNextId();
        this.width = width;
        this.aspectRatio = aspectRatio;
        this.rimDiameter = rimDiameter;
    }

    @Override
    public String toString() {
        return "Wheel{" +
                "id=" + id +
                ", width=" + width +
                ", aspectRatio=" + aspectRatio +
                ", rimDiameter=" + rimDiameter +
                '}';
    }
}
