package com.example.demo1;

import javax.faces.bean.ManagedBean;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "timetableBean")
public class TimetableBean implements Serializable {

    private static final long serialVersionUID = 1L;

    List<TimetableDTO> timetableList = fillTheList(new ArrayList<TimetableDTO>());

    public List<TimetableDTO> fillTheList(List<TimetableDTO> list) {
        list.add(new TimetableDTO("train", "station", "arrival", "departure"));
        list.add(new TimetableDTO("train2", "station2", "arrival2", "departure2"));
        list.add(new TimetableDTO("train3", "station3", "arrival3", "departure3"));
        return list;
    }

    public void getList() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/stationTimetable");
        this.timetableList = target.request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<TimetableDTO>>() {});
    }

    public String returnString() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/stationTimetable");
        String response = target.request(MediaType.TEXT_PLAIN)
                .get(String.class);
        return response;
    }

    public List<TimetableDTO> getTimetableList() {
        return timetableList;
    }

    public void setTimetableList(List<TimetableDTO> timetableList) {
        this.timetableList = timetableList;
    }
}
