package com.example.firstjavaprogram;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World" + "\n");
        byte yourAge = 30;
        long viewsCount = 3_123_456_789L;
        float price = 10.99F;
        char letter = 'A';
        boolean isEligible = true;

        Date now = new Date();
        System.out.println("This is the current date and time: " + now + "\n");

        String message = "Hello World";
//        message.endsWith("!!")
        System.out.println(message + "\n");

        String kodeddy = "Hello \"Eddy\"";
        System.out.println(kodeddy + "\n");

        int[] numbers = new int[5];
        numbers[0] = 1;
        numbers[1] = 2;
        System.out.println(Arrays.toString(numbers) + "\n");

        int[] numbers2 = {2, 3, 5, 1, 4};
        System.out.println("Length of 'numbers2' array: " + numbers2.length);
        System.out.println(Arrays.toString(numbers2));
        Arrays.sort(numbers2);
        System.out.println("Sorted version of 'numbers2': " + Arrays.toString(numbers2));

        double result = (double) 10 / (double) 3;
        System.out.println(result);

        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String currencyResult = currency.format(1234567.891);
        System.out.println(currencyResult);

//        File reading
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your age: ");
        byte age = scanner.nextByte();
        System.out.println("You are " + age);

        int i = 5;
        while (i > 0) {
            System.out.println("Hello World " + i);
            i--;
        }
    }
}
