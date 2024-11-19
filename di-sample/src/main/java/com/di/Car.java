package com.di;

public class Car {
    private String model;
    private String licenseNumber;

    public Car(String model, String licenseNumber) {
        this.model = model;
        this.licenseNumber = licenseNumber;
    }

    public String getModel() {
        return model;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }
}
