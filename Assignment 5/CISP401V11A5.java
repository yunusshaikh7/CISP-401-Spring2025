/*
 * Name: Yunus Shaikh
 * Course: CISP 401
 * Assignment: A5
 * File: CISP401V11A5.java
 * Purpose: This program demonstrates rethrowing an exception. Method
 *          CISP401Method2 throws an exception, CISP401Method catches
 *          and rethrows it, and main catches the rethrown exception
 *          and prints its stack trace.
 */

public class CISP401V11A5 {

    // Main method calls CISP401Method and catches the rethrown exception
    public static void main(String[] args) {
        try {
            CISP401Method(); // Call the method that will rethrow the exception
        }
        catch (Exception rethrownException) {
            // Print the exception message followed by its full stack trace
            System.out.println(rethrownException.getMessage());
            System.out.println(); // Blank line for cleaner output
            rethrownException.printStackTrace();
        }
    } // End of main method

    // CISP401Method calls CISP401Method2, catches the exception, and rethrows it
    public static void CISP401Method() throws Exception {
        try {
            CISP401Method2(); // Call the method that throws the original exception
        }
        catch (Exception caughtException) {
            // Rethrow the exception so that main can handle it
            throw caughtException;
        }
    } // End of CISP401Method

    // CISP401Method2 initially throws an exception with a descriptive message
    public static void CISP401Method2() throws Exception {
        // Throw a new exception to be caught and rethrown by CISP401Method
        throw new Exception("Exception thrown in CISP401Method2");
    } // End of CISP401Method2

} // End of CISP401V11A5 class