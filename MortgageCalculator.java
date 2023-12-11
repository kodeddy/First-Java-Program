package com.example.firstjavaprogram;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {
    public static void main(String[] args) {

        int principal;
        double interest;
        int years;

        principal = (int) readNumber("Principal: ", 1000, 1000000);
        interest = readNumber("Annual Interest Rate: ", 1, 30);
        years = (int) readNumber("Period (Years): ", 1, 30);

        double mortgage = calculateMortgage(principal, interest, years);
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String finalMortgage = currency.format(mortgage);
        System.out.println("Mortgage: " + finalMortgage);
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
}
