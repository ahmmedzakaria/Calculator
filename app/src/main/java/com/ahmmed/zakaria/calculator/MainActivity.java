package com.ahmmed.zakaria.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText displayEditText;
    Calculator calculator=new Calculator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayEditText= (EditText) findViewById(R.id.displayET);
    }

    public void displayNine(View view) {
        String val=displayEditText.getText().toString();
        if(val.equals("0")) {
            displayEditText.setText("");
        }
        clearDisplay();
        displayEditText.setText(displayEditText.getText().toString()+"9");
    }

    public void displayEight(View view) {
        clearDisplay();
        displayEditText.setText(displayEditText.getText().toString()+"8");
    }

    public void displaySeven(View view) {
        clearDisplay();
        displayEditText.setText(displayEditText.getText().toString()+"7");
    }

    public void displaySix(View view) {
        clearDisplay();
        displayEditText.setText(displayEditText.getText().toString()+"6");
    }

    public void displayFive(View view) {
        clearDisplay();
        displayEditText.setText(displayEditText.getText().toString()+"5");
    }

    public void displayFour(View view) {
        clearDisplay();
        displayEditText.setText(displayEditText.getText().toString()+"4");
    }

    public void displayThree(View view) {
        clearDisplay();
        displayEditText.setText(displayEditText.getText().toString()+"3");
    }

    public void displayTwo(View view) {
        clearDisplay();
        displayEditText.setText(displayEditText.getText().toString()+"2");
    }

    public void displayOne(View view) {
        clearDisplay();
        displayEditText.setText(displayEditText.getText().toString()+"1");
    }

    public void displayZero(View view) {
        clearDisplay();
        String display=displayEditText.getText().toString();
        if(/*display.equals("") || */display.equals("0")) {
            displayEditText.setText(displayEditText.getText().toString());
        }
        else{
          displayEditText.setText(displayEditText.getText().toString()+"0");
        }
    }

    public void displayPoint(View view) {
        clearDisplay();
        String displayString=displayEditText.getText().toString();
        String strArray[]=displayString.split("");
        for(String digit : strArray){
            if(digit.equals(".")){
                displayEditText.setText(displayString);
            }
            else {
                displayEditText.setText(displayString+".");
            }
        }
    }

    public void makeAddition(View view) {
        calculator.setNumberOne(getDisplayEditText());
        calculator.btn=calculator.additionBtn=true;
    }

    public void makeSubtruction(View view) {
        calculator.setNumberOne(getDisplayEditText());
        calculator.btn=calculator.subtructBtn=true;
    }

    public void makeMultiplication(View view) {
        calculator.setNumberOne(getDisplayEditText());
        calculator.btn=calculator.multiplyBtn=true;
    }

    public void makeDivision(View view) {
        calculator.setNumberOne(getDisplayEditText());
        calculator.btn=calculator.divideBtn=true;
    }

    public void percent(View view) {
        calculator.setResult(getDisplayEditText()/100.0);
        checkInteger(calculator.getResult());
        calculator.btn=calculator.percentBtn=true;
    }

    public void powr(View view) {
        calculator.setNumberOne(getDisplayEditText());
        calculator.btn=calculator.powrBtn=true;
    }

    public void root(View view) {
        calculator.setResult(Math.sqrt(getDisplayEditText()));
        checkInteger(calculator.getResult());
        calculator.btn=calculator.rootBtn=true;
    }

    public void equal(View view) {
        calculator.setNumberTwo(getDisplayEditText());
        displayEditText.setText("");
        calculateResult();
        checkInteger(calculator.getResult());
//        if(calculator.divideBtn==true && calculator.getNumberTwo().equals(0.0)) {
//            displayEditText.setText("Math Error");
//        }
        calculator.btn=calculator.equalBtn=true;
    }

    public void clearDisplay(View view) {displayEditText.setText("");
    }

    public void backSpace(View view) {
        String displayedValue;
        displayedValue=displayEditText.getText().toString();
        int length=displayedValue.length();
        StringBuilder backString=new StringBuilder(displayedValue);
        if(length>0){
            backString.deleteCharAt(length-1);
            displayedValue=backString.toString();
            displayEditText.setText(displayedValue);
        }
    }

    public void memoryPlus(View view) {
        calculator.setMemory(calculator.getMemory()+Double.parseDouble(displayEditText.getText().toString()));
    }

    public void memoryMinus(View view) {
        calculator.setMemory(calculator.getMemory()-getDisplayEditText());
    }

    public void displayMemory(View view) {
        checkInteger(calculator.getMemory());
    }

    public Double getDisplayEditText() {
        Double displayEditText=Double.parseDouble(this.displayEditText.getText().toString());
        return displayEditText;
    }

    public void setDisplayEditText(EditText displayEditText) {
        this.displayEditText = displayEditText;
    }
    public void clearDisplay(){
        if(calculator.btn) {
            displayEditText.setText("");
            calculator.btn = false;
        }
    }

//    public void clearZero(){
//        String display=displayEditText.getText().toString();
//        if(display.equals("0")||display=="0") {
//            displayEditText.setText("");
//        }
//        else{
//            displayEditText.setText(displayEditText.getText().toString()+"0");
//        }
//    }

    private void calculateResult() {

        if(calculator.additionBtn){
            calculator.setResult(calculator.getNumberOne()+calculator.getNumberTwo());
            calculator.btn=calculator.additionBtn=false;
        }
        else if(calculator.subtructBtn){
            calculator.setResult(calculator.getNumberOne()-calculator.getNumberTwo());
            calculator.btn=calculator.subtructBtn=false;
        }
        else if(calculator.multiplyBtn){
            calculator.setResult(calculator.getNumberOne()*calculator.getNumberTwo());
            calculator.btn=calculator.multiplyBtn=false;
        }
        else if(calculator.divideBtn){
                calculator.setResult(calculator.getNumberOne()/calculator.getNumberTwo());
                calculator.btn=calculator.divideBtn=false;
        }
        else if(calculator.powrBtn){
            calculator.setResult(Math.pow(calculator.getNumberOne(),calculator.getNumberTwo()));
            calculator.btn=calculator.powrBtn=false;
        }
    }

    public void checkInteger(double value){
            String intResult = "";
            String resultString = String.valueOf(value);
            String strArray[] = resultString.split("");
            if (strArray[resultString.length()].equals("0") && strArray[resultString.length() - 1].equals(".")) {
                String[] newArray = new String[resultString.length() - 1];
                for (int i = 0; i < newArray.length; i++) {
                    newArray[i] = strArray[i];
                }
                for (String i : newArray) {
                    intResult += i;
                }

                displayEditText.setText(intResult);
            } else {
                displayEditText.setText(String.valueOf(value));
            }

    }
}
