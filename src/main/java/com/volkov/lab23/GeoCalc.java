package com.volkov.lab23;

public class GeoCalc {
    private static final double VOLUME_LIMIT = 1e6;

    public double calculateCubeVolume(double sideLength) throws ValidExcept {
        if (sideLength <= 0) {
            throw new ValidExcept("Cube side length must be greater than zero.");
        }
        return Math.pow(sideLength, 3);
    }

    public double calculateSphereVolume(double radius) throws ValidExcept {
        if (radius <= 0) {
            throw new ValidExcept("Sphere radius must be greater than zero.");
        }
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }

    public double calculateCylinderVolume(double radius, double height) throws ValidExcept, CalcExcept {
        if (radius <= 0 || height <= 0) {
            throw new ValidExcept("Cylinder radius and height must be greater than zero.");
        }
        if (radius * height > VOLUME_LIMIT) {
            throw new CalcExcept("Calculated volume exceeds the allowed limit.");
        }
        return Math.PI * Math.pow(radius, 2) * height;
    }
}

