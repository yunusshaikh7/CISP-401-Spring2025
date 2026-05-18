
/*
  Name: Yunus Shaikh
  Course: CISP 401  Object Oriented Programming Using Java
  Assignment: A1
  File: Calculate.java
  Purposse: This program inputs three integers from the user and displays the sum, average
  (as an integer), product, smallest, largest, range, and median of the numbers. It also
  calculates the quotient and remainder when the largest number is divided by the smallest.
*/

import java.util.Scanner; // Import Scanner class to allow user input from keyboard

// Class name must match the file name (Calculate.java)
public class Calculate 
{
   // Main method: program execution starts here
   public static void main( String args[] )
   {
      // Create a Scanner object to read input from the command window
      Scanner input = new Scanner( System.in );

      // Declare three integer variables to store user input
      int number1; // first integer entered by the user
      int number2; // second integer entered by the user
      int number3; // third integer entered by the user

      // Prompt the user to enter the first integer
      System.out.print( "Enter first integer: " );
      number1 = input.nextInt(); // Read the first integer

      // Prompt the user to enter the second integer
      System.out.print( "Enter second integer: " );
      number2 = input.nextInt(); // Read the second integer
      
      // Prompt the user to enter the third integer
      System.out.print( "Enter third integer: " );
      number3 = input.nextInt(); // Read the third integer
      
      // Calculate the sum of the three numbers
      int sum = number1 + number2 + number3;
      
      // Calculate the product of the three numbers
      int product = number1 * number2 * number3;
      
      // Calculate the average (integer division as required by assignment)
      int average = sum / 3;
      
      // Assume the first number is the largest initially
      int largest = number1;
      
      // Compare the second number to the current largest
      if (number2 > largest)
         largest = number2;
      
      // Compare the third number to the current largest
      if (number3 > largest)
         largest = number3;
      
      // Assume the first number is the smallest initially
      int smallest = number1;
      
      // Compare the second number to the current smallest
      if (number2 < smallest)
         smallest = number2;
      
      // Compare the third number to the current smallest
      if (number3 < smallest)
         smallest = number3;
      
      // Calculate the median by subtracting largest and smallest from the sum
      int median = sum - (largest + smallest);
      
      // Calculate the range (largest minus smallest)
      int range = largest - smallest;
      
      // Calculate the quotient when the largest is divided by the smallest
      int quotient = largest / smallest;
      
      // Calculate the remainder when the largest is divided by the smallest
      int remainder = largest % smallest;
      
      // Display the entered numbers
      System.out.printf( "\nFor the numbers %d, %d and %d", number1, number2, number3 );
      
      // Display the largest value
      System.out.printf("\nThe largest is %d.", largest);
      
      // Display the smallest value
      System.out.printf("\nThe smallest is %d.", smallest);
      
      // Display the median value
      System.out.printf("\nThe median is %d.", median);
      
      // Display the range
      System.out.printf("\nThe range is %d.", range);
      
      // Display the sum
      System.out.printf("\nSum is %d.", sum);
      
      // Display the product
      System.out.printf("\nProduct is %d.", product);
      
      // Display the average
      System.out.printf("\nAverage is %d.", average);
      
      // Display the quotient of largest divided by smallest
      System.out.printf(
         "\n\nQuotient of the largest divided by the smallest is %d.", 
         quotient
      );
      
      // Display the remainder of largest divided by smallest
      System.out.printf(
         "\n\nRemainder of the largest divided by the smallest is %d.", 
         remainder
      );

   } // End of main method
} // End of Calculate class
