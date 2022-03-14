package com.andreibu.models;

public class SomeModel {
    private int intValue;
    private String stringValue;
    private float floatValue;

    public SomeModel(int intValue, String stringValue, float floatValue) {
        this.intValue = intValue;
        this.stringValue = stringValue;
        this.floatValue = floatValue;
    }

    public int getIntValue() {
        return intValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    public float getFloatValue() {
        return floatValue;
    }

    public boolean isFloatBiggerThan10() {
        return floatValue > 10.0f;
    }

    public String getId() {
        return intValue + stringValue + floatValue;
    }

    @Override
    public String toString() {
        return "SomeModel{" +
                "intValue=" + intValue +
                ", stringValue='" + stringValue + '\'' +
                ", floatValue=" + floatValue +
                '}';
    }
}