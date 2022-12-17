package helper.visitor;

import helper.SingletonScanner;
import model.Ticket;

import java.util.ArrayList;
import java.util.List;

public class MakeTicket {

    static final String IRON_TICKETS = "Iron ticket";
    static final String SILVER_TICKET = "Silver ticket";
    static final String GOLDEN_TICKET = "Golden ticket";

    private static final int IREN_TICKETS_POINTS = 10;
    private static final int SILVER_TICKET_POINTS = 50;
    private static final int GOLDEN_TICKET_POINTS = 150;


    static final int IRON_TICKETS_PRICE = 1;
    static final int SILVER_TICKET_PRICE = 3;
    static final int GOLDEN_TICKET_PRICE = 7;

    private static SingletonScanner singletonScanner = SingletonScanner.getIntent();

    public static List<Ticket> makeTickets() {
        List<Ticket> tickets = new ArrayList<>();
        do {
            Ticket ticket = makeATicket();
            tickets.add(ticket);
        }while (doYouNeedMoreTickets());
        return tickets;
    }



    private static Ticket makeATicket() {
        System.out.print("we have 3 types of tickets" +
                "\n 1-Ticket have 10 points (Iron ticket) -> 1$" +
                "\n 2-Ticket have 50 points (Silver ticket) -> 3$" +
                "\n 3-Ticket have 150 points (Golden ticket)-> 7$" +
                "\n which one you need " +
                "\n enter here -> ");
        int choice = getValidChoice(singletonScanner.scanInt());
        String type;
        int point;
        switch (choice) {
            case 1:
                type = IRON_TICKETS;
                point = IREN_TICKETS_POINTS;
                break;
            case 2:
                type = SILVER_TICKET;
                point = SILVER_TICKET_POINTS;
                break;
            default:
                type = GOLDEN_TICKET;
                point = GOLDEN_TICKET_POINTS;
                break;
        }
        Ticket ticket = new Ticket();
        ticket.setTypeOfTicket(type);
        ticket.setPoints(point);
        return ticket;
    }

    private static int getValidChoice(int choice) {
        System.out.println(choice);
        while (choice < 1 || choice > 3) {
            System.out.println("There are three choices you can enter 1 , 2, 3 \n ->");
            choice = singletonScanner.scanInt();
        }
        return choice;
    }

    private static boolean doYouNeedMoreTickets() {
        int choice = 0;
        do {
            System.out.print("Do you need more tickets \n 1-yes \n 2-no  \n -> ");
            choice = singletonScanner.scanInt();
        } while (choice != 1 && choice != 2);
        switch (choice) {
            case 1:
                return true;
            default:
                return false;
        }
    }
}
