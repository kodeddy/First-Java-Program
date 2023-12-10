package com.example.firstjavaprogram;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int principal;
        double interest;
        int years;
//        double mortgage = 0;

        System.out.print("Principal ($1K - $1M): ");
        principal = scanner.nextInt();
        while (principal > -1) {
            if (principal >= 1000 && principal <= 1000000) {
                break;
            }
            System.out.println("Enter a number between 1,000 and 1,000,000.");
            System.out.print("Principal ($1K - $1M): ");
            principal = scanner.nextInt();
        }

        System.out.print("Annual Interest Rate: ");
        interest = scanner.nextDouble();
        while (interest > 0) {
            if (interest <= 30) {
                break;
            }
            System.out.println("Enter a number greater than 0, and less than or equal to 30.");
            System.out.print("Annual Interest Rate: ");
            interest = scanner.nextDouble();
        }

        System.out.print("Period (Years): ");
        years = scanner.nextInt();
        while (years > -1) {
            if (years <= 30 && years >= 1){
                break;
            }
            System.out.println("Enter a value between 1 and 30.");
            System.out.print("Period (Years): ");
            years = scanner.nextInt();
        }

        double mortgage = calculateMortgage(principal, interest, years);
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String finalMortgage = currency.format(mortgage);
        System.out.println("Mortgage: " + finalMortgage);
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
