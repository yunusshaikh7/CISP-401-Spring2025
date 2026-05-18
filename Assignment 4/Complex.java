/*
 * Name: Yunus Shaikh
 * Course: CISP 401
 * Assignment: A4
 * File: Complex.java
 * Purpose: This class represents a complex number and performs
 *          addition, subtraction, multiplication, and division
 *          on complex numbers.
 */

public class Complex {

    private double real; // Real part of the complex number
    private double imaginary; // Imaginary part of the complex number

    // This constructor initializes the complex number to 0 + 0i
    public Complex() {
        this.real = 0.0;
        this.imaginary = 0.0;
    } // End of default constructor

    // This constructor initializes the real and imaginary parts of the complex number
    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    } // End of parameterized constructor

    // Addition of two complex numbers
    public Complex add(Complex other) {
        // (a + bi) + (c + di) = (a + c) + (b + d)i
        // Create a new Complex object to hold the result of the addition
        return new Complex(
            this.real + other.real,
            this.imaginary + other.imaginary
        );
    }

    // Subtraction of two complex numbers
    public Complex subtract(Complex other) {
        // (a + bi) - (c + di) = (a - c) + (b - d)i
        // Create a new Complex object to hold the result of the subtraction
        return new Complex(
            this.real - other.real,
            this.imaginary - other.imaginary
        );
    }

    // Multiplication of two complex numbers
    public Complex multiply(Complex other) {
        // (a + bi)(c + di) = (ac - bd) + (ad + bc)i
        // Create a new Complex object to hold the result of the multiplication
        return new Complex(
            this.real * other.real - this.imaginary * other.imaginary,
            this.real * other.imaginary + this.imaginary * other.real
        );
    }

    // Division of two complex numbers
    public Complex divide(Complex other) {
        // (a + bi) / (c + di) = [(ac + bd) + (bc - ad)i] / (c^2 + d^2)
        double denominator = other.real * other.real + other.imaginary * other.imaginary;
        // Create a new Complex object to hold the result of the division
        return new Complex(
            (this.real * other.real + this.imaginary * other.imaginary) / denominator,
            (this.imaginary * other.real - this.real * other.imaginary) / denominator
        );
    }

    // Return a string representation of the complex number
    public String toString() {
        // The %.1f format specifier formats the real and imaginary parts to one decimal place
        return String.format("(%.1f, %.1f)", real, imaginary); // Format the string to display the real and imaginary parts with one decimal place
    }

// End of Complex class
}
