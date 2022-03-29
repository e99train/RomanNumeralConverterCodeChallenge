package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("This program converts Roman Numeral values to decimal values and " +
                "vice-versa. To convert a Roman Numeral to a decimal number, simply enter a Roman" +
                " Numeral value; to convert a decimal number to Roman Numeral, enter a decimal " +
                "value. Values entered must be no less than positive 1 and no more than positive " +
                "3999. Once you are done converting values, type 'exit' to terminate the program.");

        getUserInput();
    }

    private static void getUserInput() {
        String ASK_FOR_INPUT = "Please enter a Roman Numeral or decimal value:";

        Scanner input = new Scanner(System.in);

        System.out.println(ASK_FOR_INPUT);
        String value = "";

        if (input.hasNext()) {
            value = input.next();
        }
        while (!value.equalsIgnoreCase("exit")) {

            boolean isDecimal = isDecimalNumber(value);

            Converter inputConverter = new Converter(value, isDecimal);

            while ((!inputConverter.isValid()) && (!isDecimalNumber(value)) && (!value.equalsIgnoreCase(
                    "exit"))) {
                System.out.println("Invalid input, try again:");
                if (input.hasNext()) {
                    value = input.next();
                }
                if (isValidInput(value)) {
                    isDecimal = isDecimalNumber(value);

                    inputConverter = new Converter(value, isDecimal);
                }
            }

            if (value.equalsIgnoreCase("exit")) {
                break;
            }

            if (isDecimal) {
                System.out.println(inputConverter.getResultingRomanNumeral());
            } else {
                System.out.println(inputConverter.getResultingDecimalNum());
            }

            System.out.println(ASK_FOR_INPUT);

            if (input.hasNext()) {
                value = input.next();
            }
        }
    }

    //If a decimal number entered, checks if it fits the requirements of being positive and being
    // in the range of 1 to 3999 inclusive; if a roman numeral is entered, then its validity will
    // be checked during the conversion process
    private static boolean isValidInput(String inputString) {
        if (isDecimalNumber(inputString)) {
            int num = Integer.parseInt(inputString);
            return (num >= 1) && (num <= 3999);
        }
        return true;
    }

    //Determines whether the input string is a decimal number
    private static boolean isDecimalNumber(String inputString) {
        if (inputString == null) {
            return false;
        }
        try {
            int num = Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

}
