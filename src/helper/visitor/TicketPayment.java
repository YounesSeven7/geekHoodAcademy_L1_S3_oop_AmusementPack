package helper.visitor;

import helper.SingletonScanner;
import model.Ticket;

import java.util.List;

public class TicketPayment {

    private static SingletonScanner singletonScanner = SingletonScanner.getIntent();

    public static boolean checkTicketPayment(List<Ticket> tickets) {
        System.out.println("you need " + getTicketPaymentPrice(tickets) + "$ to but this tickets");
        if(paidOrDoNot()) {
            System.out.println("Thank you for buying our tickets");
            return true;
        } else {
            System.out.println("sorry you can buy tickets if you don't have money");
            return false;
        }
    }

    private static int getTicketPaymentPrice(List<Ticket> tickets) {
        int price = 0;
        for (Ticket  ticket : tickets) {
            if (ticket.getTypeOfTicket().equals(MakeTicket.IRON_TICKETS)) {
                price = price + MakeTicket.IRON_TICKETS_PRICE;
            } else if (ticket.getTypeOfTicket().equals(MakeTicket.SILVER_TICKET)) {
                price = price + MakeTicket.SILVER_TICKET_PRICE;
            } else if (ticket.getTypeOfTicket().equals(MakeTicket.GOLDEN_TICKET)) {
                price = price + MakeTicket.GOLDEN_TICKET_PRICE;
            }
        }
        return price;
    }

    private static boolean paidOrDoNot() {
        int choice = 0;
        do {
            System.out.print("1-paid \n 2-don't paid \n ->");
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
