package org.example;

import java.util.ArrayList;
import java.util.List;

public class JSON {
    private List<Person> healthys;
    private List<Isolate> isolates;

    public JSON() {
        this.healthys = new ArrayList<>();
        this.isolates = new ArrayList<>();
    }

    public List<Person> getHealthy() {
        return healthys;
    }

    public void setHealthy(List<Person> healthys) {
        this.healthys = healthys;
    }

    public List<Isolate> getIsolate() {
        return isolates;
    }

    public void setIsolate(List<Isolate> isolate) {
        this.isolates = isolate;
    }

    public void addHealthy(Person person) {
        healthys.add(person);
    }

    public void addIsolate(Isolate isolate) {
        isolates.add(isolate);
    }

}
