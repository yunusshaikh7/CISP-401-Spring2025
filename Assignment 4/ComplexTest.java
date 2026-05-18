/*
 * Name: Yunus Shaikh
 * Course: CISP 401
 * Assignment: A4
 * File: ComplexTest.java
 * Purpose: This program creates two complex numbers and displays
 *          the results of addition, subtraction, multiplication,
 *          and division.
 */


public class ComplexTest {

    // Main method to test the ComplexTest class
    public static void main(String[] args) {
        
        Complex a = new Complex(9.5, 7.7); // Create a complex number 9.5 + 7.7i
        Complex b = new Complex(1.2, 3.1); // Create a complex number 1.2 + 3.1i

        System.out.println("A complex number in the form form (x, y) is equal to x + yi, where i is square root of -1.");
        System.out.println(); // Print an empty line for better readability

        // Display the complex numbers and the results of the operations
        System.out.println("*-Complex numbers calculations-*");

        // Uses the toString method of the Complex class to print the complex numbers in a readable format
        System.out.println("a = " + a); // Print complex number a
        System.out.println("b = " + b); // Print complex number b

        System.out.println("a + b = " + a.add(b)); // Print the result of a + b
        System.out.println("a - b = " + a.subtract(b)); // Print the result of a - b
        System.out.println("a * b = " + a.multiply(b)); // Print the result of a * b
        System.out.println("a / b = " + a.divide(b)); // Print the result of a / b

    } // End of main method


}
