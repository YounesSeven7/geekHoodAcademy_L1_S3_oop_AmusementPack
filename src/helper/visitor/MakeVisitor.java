package helper.visitor;

import helper.SingletonScanner;
import model.Visitor;

public class MakeVisitor {

    private static SingletonScanner singletonScanner = SingletonScanner.getIntent();
    public static Visitor makeAVisitor() {
        Visitor visitor = new Visitor();
        visitor.setName(enterName());
        visitor.setAge(enterAge());
        visitor.setCovid19(doYouHaveCovid19());
        boolean doYouHaveACare = doYouHaveACar();
        visitor.setHasACare(doYouHaveACare);
        if (doYouHaveACare)
            visitor.setCarParkHours(enterCarParkHour());
        else
            visitor.setCarParkHours(0);
        return visitor;
    }

    private static String enterName() {
        System.out.print("Enter your name :");
        return singletonScanner.scanString();
    }

    private static int enterAge() {
        System.out.print("Enter your age :");
        return singletonScanner.scanInt();
    }

    private static boolean doYouHaveCovid19() {
        System.out.print("do you have covid 19 \n 1-yes \n 2-no \n ->");
        int choice = singletonScanner.scanInt();
        switch (getValidYesOrNoChoice(choice)) {
            case 1:
                return true;
            default:
                return false;
        }
    }

    private static boolean doYouHaveACar() {
        System.out.print("do you have a car \n 1-yes \n 2-no \n ->");
        int choice = singletonScanner.scanInt();
        switch (getValidYesOrNoChoice(choice)) {
            case 1:
                return true;
            default:
                return false;
        }
    }

    private static int enterCarParkHour() {
        System.out.print("Enter how many hour you will use the car park ->");
        return singletonScanner.scanInt();
    }

    private static int getValidYesOrNoChoice(int choice) {
        while (choice < 1 || choice > 2) {
            System.out.print("Enter number 1 or 2 \n 1-yes \n 2-no \n ->");
            choice = singletonScanner.scanInt();
        }
        return choice;
    }
}
