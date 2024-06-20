package org.example;

import java.io.Serializable;

public class Test implements Serializable {
    private String dni;
    private Double temperature;

    public Test(String dni, Double temperature) {
        this.dni = dni;
        this.temperature = temperature;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "Test{" +
                "dni='" + dni + '\'' +
                ", temperature=" + temperature +
                '}';
    }
}