package com.example.firstjavaprogram;

import java.util.Scanner;

public class FizzBuzz {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Number: ");
        int numberInput = scanner.nextInt();

        int fizz = numberInput % 5;
        int buzz = numberInput % 3;

        if (fizz < 1 && buzz < 1) {
            System.out.println("FizzBuzz");
        } else if (buzz == 0) {
            System.out.println("Buzz");
        } else if (fizz == 0) {
            System.out.println("Fizz");
        } else {
            System.out.println(numberInput);
        }
    }
}
