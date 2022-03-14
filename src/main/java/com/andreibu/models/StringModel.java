package com.andreibu.models;

public class StringModel {
    private String id;
    private String stringValue;

    public StringModel(String id, String stringValue) {
        this.id = id;
        this.stringValue = stringValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    @Override
    public String toString() {
        return "StringModel{" +
                "id='" + id + '\'' +
                ", stringValue='" + stringValue + '\'' +
                '}';
    }
}
