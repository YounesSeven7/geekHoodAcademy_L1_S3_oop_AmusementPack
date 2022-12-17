package helper;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SingletonScanner {

    private static Scanner scanner;
    //
    private boolean isScanInt = false;
    // instance from SingletonScanner.
    private static SingletonScanner INSTANCE;
    private SingletonScanner() {
        scanner = new Scanner(System.in);
    }

    public static SingletonScanner getIntent() {
        if (INSTANCE == null) INSTANCE = new SingletonScanner();
        return INSTANCE;
    }

    public int scanInt() {
        isScanInt = true;
        return integerExceptionHandling();
    }

    private int integerExceptionHandling() {
        int number = 0;
        try {
            number = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.print("Enter integer number : ");
            scanner.nextLine();
            number = integerExceptionHandling();
        }
        return  number;
    }

    public String scanString() {
        if (isScanInt) {
            isScanInt = false;
            scanner.nextLine();
        }
        return scanner.nextLine();
    }
}
