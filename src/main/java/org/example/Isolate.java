package org.example;

public class Isolate {
    private Integer kit;
    private Double temperature;
    private String neighborhood;

    public Isolate(Integer kit, Double temperature, String neighborhood) {
        this.kit = kit;
        this.temperature = temperature;
        this.neighborhood = neighborhood;
    }

    public Integer getKit() {
        return kit;
    }

    public void setKit(int kit) {
        this.kit = kit;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }
}
