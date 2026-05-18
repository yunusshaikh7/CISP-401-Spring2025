/*
 * Name: Yunus Shaikh
 * Course: CISP 401
 * Assignment: A6
 * File: TipCalculatorController.java
 * Purpose: This is the controller for the Tip Calculator GUI. It uses
 *          listeners on the bill amount text field and the tip percent
 *          slider so that the tip and total recalculate automatically
 *          whenever the user changes either input. No Calculate button
 *          is needed.
 */

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class TipCalculatorController {

    // Formatters for displaying money and percent values in the proper format
    private static final NumberFormat currency =
        NumberFormat.getCurrencyInstance();
    private static final NumberFormat percent =
        NumberFormat.getPercentInstance();

    private BigDecimal tipPercentage = new BigDecimal("0.15"); // Default tip is 15%
    private boolean fixingInput = false; // Flag so the listener does not loop while we reset bad input

    // GUI controls wired up from the FXML file using fx:id
    @FXML
    private TextField amountTextField; // Where the user types the bill amount

    @FXML
    private Label tipPercentageLabel; // Shows the current tip percent next to the slider

    @FXML
    private Slider tipPercentageSlider; // Lets the user pick a tip percent from 0 to 30

    @FXML
    private TextField tipTextField; // Read-only field that shows the tip amount

    @FXML
    private TextField totalTextField; // Read-only field that shows bill plus tip

    // Calculates the tip and total based on the current amount and tip percent
    private void calculateTip() {
        // Skip if we are in the middle of resetting bad input (avoids infinite loop)
        if (fixingInput) {
            return;
        }

        String amountText = amountTextField.getText().trim();

        // If the field is empty or showing the prompt, clear the output fields
        if (amountText.length() == 0 || amountText.equals("Enter amount")) {
            tipTextField.clear();
            totalTextField.clear();
            return;
        }

        try {
            // Use BigDecimal for accurate money math (floating point would round wrong)
            BigDecimal amount = new BigDecimal(amountText);
            BigDecimal tip = amount.multiply(tipPercentage); // tip = amount * percent
            BigDecimal total = amount.add(tip); // total = amount + tip

            // Display the results formatted as currency
            tipTextField.setText(currency.format(tip));
            totalTextField.setText(currency.format(total));
        }
        catch (NumberFormatException ex) {
            // The user typed something that is not a number, so show a prompt
            fixingInput = true; // Block the listener so the next setText does not loop
            amountTextField.setText("Enter amount");
            amountTextField.selectAll(); // Highlight the prompt so the user can type over it
            amountTextField.requestFocus(); // Put the cursor back in the amount field
            fixingInput = false;
        }
    } // End of calculateTip method

    // initialize is called by the FXMLLoader after the FXML controls are created
    public void initialize() {
        // Round half up so values ending in .5 round up (0-4 down, 5-9 up)
        currency.setRoundingMode(RoundingMode.HALF_UP);

        // Show the starting tip percent in the label when the program opens
        tipPercentageLabel.setText(percent.format(tipPercentage));

        // Listener that recalculates whenever the amount text changes
        amountTextField.textProperty().addListener(
            new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> ov,
                    String oldValue, String newValue) {
                    calculateTip(); // Update tip and total any time the text changes
                }
            }
        );

        // Listener that recalculates whenever the user moves the tip percent slider
        tipPercentageSlider.valueProperty().addListener(
            new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> ov,
                    Number oldValue, Number newValue) {
                    // Convert the slider value (0 to 30) into a decimal percent (0.00 to 0.30)
                    tipPercentage =
                        BigDecimal.valueOf(newValue.intValue() / 100.0);
                    tipPercentageLabel.setText(percent.format(tipPercentage)); // Update the label
                    calculateTip(); // Recalculate using the new tip percent
                }
            }
        );
    } // End of initialize method

} // End of TipCalculatorController class