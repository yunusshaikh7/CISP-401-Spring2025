/*
 * Name: Yunus Shaikh
 * Course: CISP 401
 * Assignment: A6
 * File: TipCalculator.java
 * Purpose: This program launches the Tip Calculator app. It loads the
 *          GUI layout from the FXML file, builds the scene, and shows
 *          the window. All of the calculation logic lives in the
 *          controller class, not here.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TipCalculator extends Application {

    // start method is called by the JavaFX runtime after launch
    @Override
    public void start(Stage stage) throws Exception {
        // Load the scene graph defined in the FXML file
        Parent root =
            FXMLLoader.load(getClass().getResource("TipCalculator.fxml"));

        Scene scene = new Scene(root); // Attach the scene graph to a new scene
        stage.setTitle("Tip Calculator"); // Text shown in the window title bar
        stage.setScene(scene); // Attach the scene to the stage
        stage.show(); // Display the stage on screen
    } // End of start method

    // main launches the JavaFX application
    public static void main(String[] args) {
        // launch sets up the JavaFX runtime and then calls start
        launch(args);
    } // End of main method

} // End of TipCalculator class