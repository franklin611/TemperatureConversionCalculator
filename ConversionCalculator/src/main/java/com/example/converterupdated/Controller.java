 package com.example.converterupdated;

import javafx.fxml.FXML;
import javafx.scene.control.*;

 public class Controller {

    @FXML
    private TextField inputField;

    @FXML
    private TextField outputField;

    @FXML
    private Button clearButton;

    @FXML
    private Button convertButton;

    @FXML
    private ComboBox from;

    @FXML
    private ComboBox to;

    public Integer calculations;


    public void initialize(){
       convertButton.setDisable(true);
       clearButton.setDisable(true);
    }

    public void convertChange(){
        int selectedInput = from.getSelectionModel().getSelectedIndex();
       Object selectedInputItem = from.getSelectionModel().getSelectedItem();

       int selectedOutput = to.getSelectionModel().getSelectedIndex();
       Object selectedOutputItem = to.getSelectionModel().getSelectedItem();

       String inputText = inputField.getText();

       if(selectedInput < 0 || selectedOutput < 0){

       }
        try {
            double x = Double.parseDouble(inputText);

            if (selectedInput == 0 && selectedOutput == 0) {
                outputField.setText("Answer: " + inputText + " °C"); //C, F, K, R
            } else if (selectedInput == 0 && selectedOutput == 1) {
                outputField.setText("Answer: " + String.format("%.4f", (x - 32) * 9 / 5)+ " °F");
            } else if (selectedInput == 0 && selectedOutput == 2) {
                outputField.setText("Answer: " + String.format("%.4f", (x +273.15))+ " K");
            } else if (selectedInput == 0 && selectedOutput == 3) {
                outputField.setText("Answer: " + String.format("%.4f", (x * 9/5 + 491.67))+ " °R");


            } else if (selectedInput == 1 && selectedOutput == 0) {
               outputField.setText("Answer: " + String.format("%.4f", (x - 32) * 5 / 9) +  " °C");

            } else if (selectedInput == 1 && selectedOutput == 1) {
                outputField.setText("Answer: " + inputText + " °F");
            } else if (selectedInput == 1 && selectedOutput == 2) {
                outputField.setText("Answer: " + String.format("%.4f", (x + 459.67) * 5 / 9) + " k");
            } else if (selectedInput == 1 && selectedOutput == 3) {
                outputField.setText("Answer: " + String.format("%.4f", (x + 459.67)) + " °r");


            } else if (selectedInput == 2 && selectedOutput == 0) {
                outputField.setText("Answer: " + String.format("%.4f", (x - 273.15)) + " °C" );
            } else if (selectedInput == 2 && selectedOutput == 1) {
                outputField.setText("Answer: " + String.format("%.4f", ((x * 9/5) + 459.67)) + " °F");
            } else if (selectedInput == 2 && selectedOutput == 2) {
                outputField.setText("Answer: " + inputText + " K");
            } else if (selectedInput == 2 && selectedOutput == 3) {
                outputField.setText("Answer: " +  String.format("%.4f", (x * 9/5)) + " °R");


            } else if (selectedInput == 3 && selectedOutput == 0) {
                outputField.setText("Answer: " + String.format("%.4f", ((x * 5/9) - 273.15)) + " °C");
            } else if (selectedInput == 3 && selectedOutput == 1) {
                outputField.setText("Answer: " + String.format("%.4f", x - 459.67) + " °F");
            } else if (selectedInput == 3 && selectedOutput == 2) {
                outputField.setText("Answer: " + String.format("%.4f", (x  * 5 / 9)) + " K");
            } else if (selectedInput == 3 && selectedOutput == 3) {
                outputField.setText("Answer: " + inputText + " °R");

            } else {

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("No Temperatures Units Selected");
                    alert.setHeaderText(null);
                    alert.setContentText("Please select the units you would like to convert to and from. ");
                    alert.showAndWait();
            }
        }
        catch(NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Incorrect Input type.");
            alert.setHeaderText(null);
            alert.setContentText("Pleas e input numbers.");
            alert.showAndWait();
            }
    }

    public void clearAll(){
       inputField.clear();
       outputField.setText("Answer:");
       convertButton.setDisable(true);
       clearButton.setDisable(true);
    }
    @FXML
    public void handleKeyReleased(){
       String text = inputField.getText();
       boolean disableButtons  =text.isEmpty() || text.trim().isEmpty() || text.trim().equals("");
       convertButton.setDisable(disableButtons);
       clearButton.setDisable(disableButtons);

    }
}