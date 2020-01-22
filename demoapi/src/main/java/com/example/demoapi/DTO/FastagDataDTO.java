package com.example.demoapi.DTO;

public class FastagDataDTO {
    private FastagDTO fastag;
    private Integer id;
    private Boolean latest;
    private String state;
    private VehicleDTO vehicle;

    public FastagDTO getFastag() {
        return fastag;
    }

    public void setFastag(FastagDTO fastag) {
        this.fastag = fastag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getLatest() {
        return latest;
    }

    public void setLatest(Boolean latest) {
        this.latest = latest;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public VehicleDTO getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleDTO vehicle) {
        this.vehicle = vehicle;
    }
}
