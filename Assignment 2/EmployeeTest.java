/*
  Name: Yunus Shaikh
  Course: CISP 401  Object Oriented Programming Using Java
  Assignment: A2
  File: EmployeeTest.java
  Purpose: This program tests the employee class by creating three employee objects, displaying their yearly salary, 
  giving them a 10% raise, and then displaying their yearly salary again.
*/

public class EmployeeTest {

    // Main method to test the Employee class
    public static void main(String[] args) {
        
        // Creating three employee objects with first name, last name, and monthly salary
        Employee emp1 = new Employee("Bob", "Jones", 2875.00);
        Employee emp2 = new Employee("Susan", "Baker", 3150.75);
        Employee emp3 = new Employee("John", "Lin", -5000.00); // This will trigger the negative salary handling in the Employee constructor

        // Displaying the yearly salary of each employee
        System.out.printf(
            // Using printf to format the output for each employee's yearly salary
            "Employee 1: %s %s: Yearly Salary: %.2f%n",
            emp1.getFirstName(),
            emp1.getLastName(),
            emp1.getMonthlySalary() * 12 // Multiply monthly salary by 12 to get yearly salary
        );

        System.out.printf(
            "Employee 2: %s %s: Yearly Salary: %.2f%n",
            emp2.getFirstName(),
            emp2.getLastName(),
            emp2.getMonthlySalary() * 12
        );

        System.out.printf(
            "Employee 3: %s %s: Yearly Salary: %.2f%n",
            emp3.getFirstName(),
            emp3.getLastName(),
            emp3.getMonthlySalary() * 12
        );

        // Adding a line break for better readability
        System.out.println();

        System.out.println("Increasing employee salaries by 10%");
        
        // Giving each employee a 10% raise by multiplying their monthly salary by 1.10
        emp1.setmonthlySalary(emp1.getMonthlySalary() * 1.10);
        emp2.setmonthlySalary(emp2.getMonthlySalary() * 1.10);
        emp3.setmonthlySalary(emp3.getMonthlySalary() * 1.10);

        // Displaying the yearly salary of each employee again after the raise
        System.out.printf(
            "Employee 1: %s %s: Yearly Salary: %.2f%n",
            emp1.getFirstName(),
            emp1.getLastName(),
            emp1.getMonthlySalary() * 12 // Multiply monthly salary by 12 to get yearly salary
        );

        System.out.printf(
            "Employee 2: %s %s: Yearly Salary: %.2f%n",
            emp2.getFirstName(),
            emp2.getLastName(),
            emp2.getMonthlySalary() * 12
        );

        System.out.printf(
            "Employee 3: %s %s: Yearly Salary: %.2f%n",
            emp3.getFirstName(),
            emp3.getLastName(),
            emp3.getMonthlySalary() * 12
        );

    }// End of main method

}// End of EmployeeTest class
