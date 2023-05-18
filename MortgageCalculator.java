package com.example.firstjavaprogram;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int principal;
        double interest;
        int years;
        double mortgage;


        System.out.print("Principal: ");
        principal = scanner.nextInt();

        System.out.print("Annual Interest Rate: ");
        interest = scanner.nextDouble();

        System.out.print("Period (Years): ");
        years = scanner.nextInt();

        double monthlyInterest = (interest / 100) / 12;
        int period = years * 12;
        double fractionConstant = Math.pow(1 + monthlyInterest, period);

        mortgage = principal * (monthlyInterest * fractionConstant) / (fractionConstant - 1);
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String finalMortgage = currency.format(mortgage);

        System.out.println("Mortgage: " + finalMortgage);
    }
}
