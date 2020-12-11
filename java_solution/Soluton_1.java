import java.util.Scanner;

//! Challenge
// Challenge 1 > A method that displays the number of characters in a user input 

// Challenge 2 > A method that prompts user for their first and last name and returns a username composed of the first character of their first name and the last name (Eg. John Doe returns jdoe). Note that the username is all lower case

// Challenge 3 > A method that accepts a String argument and determines and display whether or not the argument is uppercase, lowercase, or a digit

// Challenge 4 > A method that accepts two arguments; an Integer 'pos' and a String 'text'. The method should return the character located in the index of 'pos' in 'text'. Your method should address all exceptions.

// Challenge 5 > A method that replaces all occurences of 'o' in a given String value with 'x'

public class Soluton_1 {
    static Scanner scan = new Scanner(System.in);

    // > Challenge 1's method
    static void numberOfChars() {
        System.out.println();
        System.out.println("Challenge one: number of chars");

        // * First need to prompt for user input
        System.out.print("Please enter a string of characters to get it's count: ");

        // * Then accept the user's input
        String userInput = scan.nextLine(); // accepting input

        // * Then count and display the number of input
        System.out.println("The number of characters in " + userInput + " is " + userInput.length());
    }

    // > Challeng 2's method
    static String username() {
        System.out.println();
        System.out.println("Challenge 2: Username");
        // * prompting for first name and last name

        System.out.print("first name: ");
        String firstName = scan.nextLine();

        System.out.print("last name: ");
        String lastName = scan.nextLine();

        // * returning required username
        String username = firstName.charAt(0) + lastName;
        System.out.println("username: " + username.toLowerCase());

        return username;

    }

    // > Challenge 3's method - I didn't understand the problem too much so I
    // progammed the method to detect the specified types in a given String
    static void argumentType(String argument) {
        System.out.println();
        System.out.println("Challenge 3: argument type");
        System.out.println("Given argument: " + argument);

        // * converting argument to an array to facilitate iteration
        char[] argumentCopy = argument.toCharArray();

        // * variables to keep track of detected types
        boolean isUppercaseDetected = false;
        boolean isLowercaseDetected = false;
        boolean isDigitDetected = false;
        int numberOfDetectedCases = 0; // * only needed for the advanced output ;)

        // * checking type of each char in the array argument copy
        // ! Logic
        // * for each char (say, the test char)
        for (char character : argumentCopy) {

            // * compare the test char type against the given types
            // * if a given type is not already detected,
            if (!isUppercaseDetected) {
                // * check if it matches the given type and store the outcome
                isUppercaseDetected = Character.isUpperCase(character);
                //this isn't too necessary at this point unless you want a nicer looking output ;)
                numberOfDetectedCases = isUppercaseDetected ? ++numberOfDetectedCases : numberOfDetectedCases; 
            }
            if (!isLowercaseDetected) {
                isLowercaseDetected = Character.isLowerCase(character);
                numberOfDetectedCases = isLowercaseDetected ? ++numberOfDetectedCases : numberOfDetectedCases;
            }
            if (!isDigitDetected) {
                isDigitDetected = Character.isDigit(character);
                numberOfDetectedCases = isDigitDetected ? ++numberOfDetectedCases : numberOfDetectedCases;
            }
        }

        // * Simple output system

        // String result = "";
        // if(isUppercaseDetected)
        // result += "Uppercase Detected \n";
        // if(isLowercaseDetected)
        // result += "Lowercase Detected \n";
        // if(isDigitDetected)
        // result += "Digit Detected ";

        // System.out.println(result);

        // * more advanced output system

        String result = "";
        if (isUppercaseDetected)
            result += "Uppercase";
        if (isLowercaseDetected) {
            if (isUppercaseDetected && numberOfDetectedCases != 2)
                result += ", Lowercase";
            if (isUppercaseDetected && numberOfDetectedCases == 2)
                result += " and Lowercase";
            else
                result += "Lowercase";
        }
        if (isDigitDetected) {
            if (isUppercaseDetected || isLowercaseDetected)
                result += " and Digit";
            else
                result += "Digit";
        }
        if (isDigitDetected || isLowercaseDetected || isDigitDetected)
            result += " Detected";
        else
            result += "No Uppercase, Lowercase or Digit detected";
        System.out.println(result);

    }

    // > Challenge 4's method
    static void findChar(int pos, String text) {
        System.out.println();
        System.out.println("Challenge 4: find char");
        System.out.println("given pos value: " + pos);
        System.out.println("given text value: " + text);
        // * addressing all exceptions
        try {
            System.out.println("char at index " + pos + " of the text: " + text + " is " + text.charAt(pos));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // > Challenge 5's method
    static void o_to_x() {
        System.out.println();
        System.out.println("Challenge 5: o to x");

        // * prompt and input
        System.out.print("Enter String here: ");
        String userInput = scan.nextLine();

        // * creating an array of chars out of input for iteration
        char[] userInputCopy = userInput.toCharArray();

        // * changing all occurrences of 'o' to 'x'
        for (int i = 0; i < userInputCopy.length; i++)
            userInputCopy[i] = userInputCopy[i] == 'o' ? 'x' : userInputCopy[i];

        // * output ;)
        System.out.print("all 'o's have been successfully converted to 'x's: ");
        System.out.println(userInputCopy);
    }

    public static void main(String[] args) {

        // test

        // challenge 1
        numberOfChars();

        // challenge 2
        username();

        // challenge 3
        argumentType("G4me8woy"); // change the argument to test different cases

        // challenge 4
        findChar(4, "G4me8woy"); // change the argument to test different cases

        // challenge 5
        o_to_x();

    }
}