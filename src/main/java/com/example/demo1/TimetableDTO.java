package com.example.demo1;


import javax.faces.bean.ManagedBean;

@ManagedBean
public class TimetableDTO {

    private String trainId;

    private String stationId;

    private String arrivalTime;

    private String departureTime;

    public TimetableDTO() {
    }

    public TimetableDTO(String trainId, String stationId, String arrivalTime, String departureTime) {
        this.trainId = trainId;
        this.stationId = stationId;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
    }

    public String getTrainId() {
        return trainId;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }
}
