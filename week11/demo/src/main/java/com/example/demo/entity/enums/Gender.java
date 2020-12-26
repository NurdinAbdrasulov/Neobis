package com.example.demo.entity.enums;

public enum Gender {
    MALE("Муж"),
    FEMALE("Жен");

    private final String label;
    private Gender(String label){
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
