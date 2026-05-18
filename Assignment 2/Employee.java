/*
  Name: Yunus Shaikh
  Course: CISP 401  Object Oriented Programming Using Java
  Assignment: A2
  File: Employee.java
  Purpose: This program creates an Employee class with first name, last name, and monthly salary.
*/


public class Employee {

    // Instance variables for first name, last name, and monthly salary
    String firstName; 
    String lastName;
    double monthlySalary;
    
    //Constructor
    public Employee(String firstName, String lastName, double monthlySalary) {

        // Initializing the instance variables with the provided values
        this.firstName = firstName;
        this.lastName = lastName;

        // Handling negative salary input by setting it to 1000.00 and printing a message
        if (monthlySalary < 0.0) {

            System.out.printf("***The inputted salary: %.2f for %s %s is less than zero.%n",
            monthlySalary, firstName, lastName);
            this.monthlySalary = 1000.00; // Set the salary to 1000.00 if the input is negative
            System.out.printf("Set the salary to %,.2f.***%n%n", this.monthlySalary);

        } 
        // If the input salary is not negative, set it to the provided value
        else {
            this.monthlySalary = monthlySalary; // Set the salary to the provided value if it's not negative
        }

    } // End of constructor

    //Setters and Getters

    // Getter for first name
    public String getFirstName() {
        return firstName;
    }

    // Setter for first name
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Getter for last name
    public String getLastName() {
        return lastName;
    }

    // Setter for last name
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Getter for monthly salary
    public double getMonthlySalary() {
        return monthlySalary;
    }

    // Setter for monthly salary with validation to prevent negative values
    public void setmonthlySalary(double monthlySalary) {

        // Handling negative salary input by setting it to 1000.00 and printing a message
        if (monthlySalary < 0.0) {

            System.out.printf("***The inputted salary: %.2f for %s %s is less than zero.%n",
            monthlySalary, firstName, lastName);
            this.monthlySalary = 1000.00; // Set the salary to 1000.00 if the input is negative
            System.out.printf("Set the salary to %,.2f.***%n%n", this.monthlySalary);

        } 
        // If the input salary is not negative, set it to the provided value
        else {
            this.monthlySalary = monthlySalary;
        }

    }

} // End of Employee class