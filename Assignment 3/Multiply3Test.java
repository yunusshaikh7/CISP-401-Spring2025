/*
  Name: Yunus Shaikh
  Course: CISP 401  Object Oriented Programming Using Java
  Assignment: A3
  File: Multiply3Test.java
  Purpose: This program tests the Multiply3 class by starting the multiplication quiz
  and then printing all recorded question results and summary information.
*/

public class Multiply3Test {

    // Main method to test the Multiply3 class
    public static void main(String[] args) {

        // Creating a Multiply3 object to run the multiplication quiz
        Multiply3 quizObject = new Multiply3();

        // Starting the interactive quiz
        quizObject.quiz();

        // Printing the stored questions, answers, and statistics after the user exits
        quizObject.printQuestionResult();

    } // End of main method

} // End of Multiply3Test class
