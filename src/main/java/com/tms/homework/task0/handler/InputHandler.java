package com.tms.homework.task0.handler;

import java.util.Locale;
import java.util.Scanner;

public class InputHandler {

    public static double inputDoubleField() {
        double number;
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        while (!scanner.hasNextDouble()) {
            System.out.println("That not a number! Try again");
            scanner.next();
        }
        number = scanner.nextDouble();
        return number;
    }
}
