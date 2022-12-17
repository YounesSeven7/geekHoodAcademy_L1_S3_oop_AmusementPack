package helper.visitor;

import helper.SingletonScanner;
import model.Ticket;
import model.Visitor;

import java.util.ArrayList;
import java.util.List;


public class AmusementPack {
    private static int visitorNumber = 1;

    private static SingletonScanner singletonScanner = SingletonScanner.getIntent();
    private static List<Visitor> visitorsList = new ArrayList<>();
    private static void welcomeMessage() {
        System.out.println("welcome in our Amusement pack, insert any visitor you need." +
                "\n The age 16 or less than 1$ " +
                "\n The age more than 16 3$" +
                "\n If you have a care you will paid 5$ for every 3 hours" +
                "\n You must don't have covid 19");
    }

    public static List<Visitor> getVisitorsList() {
        welcomeMessage();
        do {
            System.out.println("The visitor number " + visitorNumber);
            Visitor visitor = MakeVisitor.makeAVisitor();
            if (!checkCovid19(visitor)) {
                if (checkVisitorPayment(visitor)) {
                    List<Ticket> tickets = MakeTicket.makeTickets();
                    if (TicketPayment.checkTicketPayment(tickets)) {
                        visitor.setTickets(tickets);
                    }
                }
            }
        } while (doYouNeedMoreVisitors());
        return visitorsList;
    }

    private static boolean checkCovid19(Visitor visitor) {
        if (visitor.isCovid19()) {
            System.out.println("sorry you have covid 19 , you can't enter");
            return true;
        } else {
            System.out.println("you don't have covid, now we check your payment");
            return false;
        }
    }

    private static boolean checkVisitorPayment(Visitor visitor) {
        boolean checkVisitorPayment =  VisitorPayment.checkVisitorPayment(visitor);
        if (checkVisitorPayment) {
            visitorsList.add(visitor);
            visitorNumber++;
            System.out.println("welcome in our Amusement park");
            return true;
        } else {
            System.out.print("sorry you can enter if you don't have money");
            return false;
        }
    }


    private static boolean doYouNeedMoreVisitors() {
        int choice = 0;
        do {
            System.out.print("Do you need more visitor \n 1-yes \n 2-no  \n -> ");
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
