package model;

import java.util.List;

public class Visitor {
    private String name;
    private int age;
    private boolean covid19, hasACare;
    private int carParkHours, ticketPoints;
    private List<Ticket> tickets;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isCovid19() {
        return covid19;
    }

    public void setCovid19(boolean covid19) {
        this.covid19 = covid19;
    }

    public boolean isHasACare() {
        return hasACare;
    }

    public void setHasACare(boolean hasACare) {
        this.hasACare = hasACare;
    }

    public int getCarParkHours() {
        return carParkHours;
    }

    public void setCarParkHours(int carParkHours) {
        this.carParkHours = carParkHours;
    }

    public int getTicketPoints() {
        return ticketPoints;
    }

    public void setTicketPoints(int ticketPoints) {
        this.ticketPoints = ticketPoints;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
