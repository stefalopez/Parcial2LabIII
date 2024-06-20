package org.example;

import java.io.Serializable;

public class Person implements Serializable {
    private String firstName;
    private String lastName;
    private Integer age;
    private String neighborhood;
    private String dni;
    private String occupation;
    private Integer kitNumber;

    public Person(String firstName, String lastName, Integer age, String neighborhood, String dni, String occupation) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.neighborhood = neighborhood;
        this.dni = dni;
        this.occupation = occupation;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Integer getKitNumber() {
        return kitNumber;
    }

    public void setKitNumber(Integer kitNumber) {
        this.kitNumber = kitNumber;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", neighborhood='" + neighborhood + '\'' +
                ", dni='" + dni + '\'' +
                ", occupation='" + occupation + '\'' +
                ", kitNumber=" + kitNumber +
                '}';
    }
}