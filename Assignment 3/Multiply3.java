/*
  Name: Yunus Shaikh
  Course: CISP 401  Object Oriented Programming Using Java
  Assignment: A3
  File: Multiply3.java
  Purpose: This program generates one-digit multiplication questions, checks user answers,
  stores up to 100 question results, and prints a summary report when the user exits.
*/

/*

Outline

- quiz method generatres the UI and create question
- createQuestion method generates a new one-digit multiplication question
- quiz method continues to ask questions until the user enters -1 or the array is full
- quiz method calls checkResponse method to check the user's answer and store the result
- checkResponse method checks whether the user's answer is correct and stores the question and result in the array
- checkResponse method prints a random response based on whether the answer is correct
- checkResponse method generates the next question if there is still space in the array
- goes back to quiz method to ask the next question
- when the user exits, quiz method calls printQuestionResult method to print all stored question results and summary statistics

*/

import java.util.Random; // Importing the Random class to generate
import java.util.Scanner; // Importing the Scanner class to read user input

public class Multiply3 {

    // Random object used to generate questions and response messages
    Random random = new Random();

    // Scanner object used to read user input
    Scanner input = new Scanner(System.in);

    // 100 by 5 array to store up to 100 multiplication question results
    // Column 0 = first factor
    // Column 1 = second factor
    // Column 2 = user's answer
    // Column 3 = correct answer
    // Column 4 = result flag (1 = correct, 0 = incorrect)
    int[][] questionResults = new int[100][5];

    // Instance variables for the current multiplication question
    int firstNumber;
    int secondNumber;
    int correctAnswer;

    // Counter for how many questions were answered
    int questionCount = 0;

    // Counter for how many questions were answered incorrectly
    int wrongCount = 0;

    // Constructor
    public Multiply3() {

    }

    // quiz function generates the user interface for the multiplication quiz
    public void quiz() {

        int studentAnswer;

        // Generate the first question when the quiz begins
        createQuestion();

        // Continue asking questions until the user enters -1 or the array is full
        while (questionCount < questionResults.length) {

            System.out.printf("How much is %d times %d?%n", firstNumber, secondNumber);
            System.out.print("Enter your answer (-1 to exit): ");
            studentAnswer = input.nextInt();

            // If the user enters -1, stop the quiz immediately
            if (studentAnswer == -1) {
                break;
            }

            // Check the student's answer
            checkResponse(studentAnswer);
        }
    }

    // createQuestion function generates a new one-digit multiplication question
    public void createQuestion() {

        // Generate two positive one-digit integers from 1 through 9
        firstNumber = random.nextInt(9) + 1;
        secondNumber = random.nextInt(9) + 1;

        // Calculate the correct answer for the current question
        correctAnswer = firstNumber * secondNumber;
    }

    // createResponse function returns a random response based on whether the answer is correct
    public String createResponse(boolean isCorrect) {

        // Generate a random number from 1 to 4 to select a response
        int responseNumber = random.nextInt(4) + 1;

        // If the answer is correct, return one of the positive responses
        if (isCorrect) {
            switch (responseNumber) {
                case 1:
                    return "Very good!";
                case 2:
                    return "Excellent!";
                case 3:
                    return "Nice work!";
                default:
                    return "Keep up the good work!";
            }
        }
        // If the answer is incorrect, return one of the negative responses
        else {
            switch (responseNumber) {
                case 1:
                    return "No. Please try again.";
                case 2:
                    return "Wrong. Try once more.";
                case 3:
                    return "Don't give up!";
                default:
                    return "No. Keep trying.";
            }
        }
    }

    // checkResponse function checks whether the user's answer is correct
    public void checkResponse(int answer) {

        // Determine whether the answer is correct
        boolean isCorrect = (answer == correctAnswer);

        // Store the current question and result if there is still room in the array
        if (questionCount < questionResults.length) {
            questionResults[questionCount][0] = firstNumber;
            questionResults[questionCount][1] = secondNumber;
            questionResults[questionCount][2] = answer;
            questionResults[questionCount][3] = correctAnswer;
            questionResults[questionCount][4] = isCorrect ? 1 : 0;
        }

        // If the answer is correct, print a positive response
        if (isCorrect) {
            System.out.println(createResponse(true));
        }
        // If the answer is incorrect, print a negative response and the correct answer
        else {
            wrongCount++;
            System.out.println(createResponse(false));
            System.out.printf("The correct answer is %d.%n", correctAnswer);
        }

        // Move to the next stored result
        questionCount++;

        // Add a blank line for cleaner output formatting
        System.out.println();

        // Generate the next question only if there is still space in the array
        if (questionCount < questionResults.length) {
            createQuestion();
        }
    }

    // printQuestionResult function prints all stored question results and summary statistics
    public void printQuestionResult() {

        int correctCount = questionCount - wrongCount;
        String finalRemark;

        System.out.println("The questions generated by the system are:");

        // Print all questions, user answers, and incorrect-answer remarks when needed
        for (int i = 0; i < questionCount; i++) {

            System.out.printf(
                "%d x %d = %d%n",
                questionResults[i][0],
                questionResults[i][1],
                questionResults[i][2]
            );

            // If the question was answered incorrectly, print the correct answer remark
            if (questionResults[i][4] == 0) {
                System.out.printf(
                    "The answer was %d, which is incorrect.%n",
                    questionResults[i][3]
                );
            }
        }

        System.out.println();
        System.out.printf(
            "You got %d questions and made %d questions correct.%n",
            questionCount,
            correctCount
        );

        // If more than one third of the answers are wrong, choose a negative final remark
        if (questionCount > 0 && wrongCount * 3 > questionCount) {
            finalRemark = createResponse(false);
        }
        // Otherwise choose a positive final remark
        else {
            finalRemark = createResponse(true);
        }

        System.out.println(finalRemark);
    }

} // End of Multiply3 class
