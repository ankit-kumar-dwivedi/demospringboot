package com.example.demoapi.DTO;

import java.util.List;

public class VehicleFastagFilterRequest {
    private List<Integer> fastagIds = null;
    private List<String> fastagSerialNumbers = null;
    private Boolean latest;
    private Boolean paging;
    private List<Integer> vehicleIds = null;
    private String vehicleNumber;
    private String vehicleSearchType;

    public List<Integer> getFastagIds() {
        return fastagIds;
    }

    public void setFastagIds(List<Integer> fastagIds) {
        this.fastagIds = fastagIds;
    }

    public List<String> getFastagSerialNumbers() {
        return fastagSerialNumbers;
    }

    public void setFastagSerialNumbers(List<String> fastagSerialNumbers) {
        this.fastagSerialNumbers = fastagSerialNumbers;
    }

    public Boolean getLatest() {
        return latest;
    }

    public void setLatest(Boolean latest) {
        this.latest = latest;
    }

    public Boolean getPaging() {
        return paging;
    }

    public void setPaging(Boolean paging) {
        this.paging = paging;
    }

    public List<Integer> getVehicleIds() {
        return vehicleIds;
    }

    public void setVehicleIds(List<Integer> vehicleIds) {
        this.vehicleIds = vehicleIds;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleSearchType() {
        return vehicleSearchType;
    }

    public void setVehicleSearchType(String vehicleSearchType) {
        this.vehicleSearchType = vehicleSearchType;
    }
}
