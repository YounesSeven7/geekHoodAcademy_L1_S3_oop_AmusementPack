package helper.visitor;

import helper.SingletonScanner;
import model.Visitor;

import javax.sound.midi.Soundbank;

public class VisitorPayment {

    private static SingletonScanner singletonScanner = SingletonScanner.getIntent();
    public static boolean checkVisitorPayment(Visitor visitor) {
        int allPaymentPrice = getEntryPaymentPrice(visitor) + getCarParkPaymentPrice(visitor);
        System.out.println("The full price is " + allPaymentPrice + "$");
        boolean paidOrDoNot = paidOrDoNot();
        if (paidOrDoNot) {
            return true;
        } else{
            return false;
        }
    }

    private static int getEntryPaymentPrice(Visitor visitor) {
        if (visitor.getAge()<=16) {
            System.out.print("you need 1$ to enter ,");
            return 1;
        } else {
            System.out.print("you need 3$ to enter ,");
            return 3;
        }
    }
    private static int getCarParkPaymentPrice(Visitor visitor) {
        if (!visitor.isHasACare()) {
            return 0;
        } else {
            int carParkPaymentPrice = calculateCarParkPaymentPrice(visitor.getCarParkHours());
            System.out.println("you need " + carParkPaymentPrice + "$ to use car park");
            return carParkPaymentPrice;
        }
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

    private static int calculateCarParkPaymentPrice(int hours) {
        int salary = hours % 3 == 0 ? (hours / 3) * 5 : (hours / 3) * 5 + 5;
        return salary;
    }



}
