package com.example.firstjavaprogram;

import java.text.NumberFormat;
import java.util.Scanner;

public class PaymentCalculator {

    public static void main(String[] args) {
        int principal = (int) readNumber("Principal: ", 1000, 1000000);
        double interest = readNumber("Annual Interest Rate: ", 1, 30);
        int years = (int) readNumber("Period (Years): ", 1, 30);

        double mortgage = calculateMortgage(principal, interest, years);
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String finalMortgage = currency.format(mortgage);
        System.out.println("MORTGAGE");
        System.out.println();
        System.out.println("________");
        System.out.println("Monthly Payments: " + finalMortgage);
        System.out.println("PAYMENT SCHEDULE");
        System.out.println();
        System.out.println("________________");

        double balance;
        double paymentNumber = years * 12;
        int paymentsMade = 0;
        double monthlyInterest = (interest / 100) / 12;

        while (paymentsMade < paymentNumber){
            paymentsMade++;
            int i = paymentsMade;
            double topPart = Math.pow(1 + monthlyInterest, paymentNumber) - Math.pow(1 + monthlyInterest, i);
            double bottomPart = Math.pow(1 + monthlyInterest, paymentNumber) - 1;
            balance = principal * (topPart / bottomPart);
            String finalBalance = currency.format(balance);
            System.out.println(finalBalance);
        }


    }

    public static double readNumber(String prompt, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        double value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextDouble();
            if (value >= min && value <= max) {
                break;
            }
            System.out.println("Enter a number between " + min + " and " + max);
        }
        return value;
    }

    public static double calculateMortgage(int principal,
                                           double interest,
                                           int years){
        int period = years * 12;
        double monthlyInterest = (interest / 100) / 12;
        double fractionConstant = Math.pow(1 + monthlyInterest, period);
        double mortgage;
        mortgage = principal * (monthlyInterest * fractionConstant) / (fractionConstant - 1);
        return mortgage;
    }

//    public static double calculator(int principal, double interest, int years, int paymentsMade) {
//        double balance;
//        double paymentNumber = years * 12;
//
//        double topPart = Math.pow(1 + interest, paymentNumber) - Math.pow(1 + interest, paymentsMade);
//        double bottomPart = Math.pow(1 + interest, paymentNumber) - 1;
//        balance = principal * (topPart / bottomPart);
//        return balance;
//    }

}
