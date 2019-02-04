package MK.FareCompetitorsInterfaces.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class CompetitorsData {
    private String airline;
    private String origin;
    private String destination;
    private String date;
    private Double fare;

    public CompetitorsData(String airline, String origin, String destination, String date, Double fare){
        this.airline = airline;
        this.origin = origin;
        this .destination = destination;
        this.date = date;
        this.fare = fare;
    }



    //Introducing the dummy constructor
    public CompetitorsData() {
    }


    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getFare() {
        return fare;
    }

    public void setFare(Double fare) {
        this.fare = fare;
    }
}
