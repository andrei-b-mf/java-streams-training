package com.andreibu.models;

public enum WheelMounting {
    FRONT_LEFT(0),
    FRONT_RIGHT(1),
    REAR_LEFT(2),
    READ_RIGHT(3);

    private int value;

    WheelMounting(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
