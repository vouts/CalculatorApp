package com.example.android.calculatorapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    /**
     * Variable Declaration
     */
    double firstNumber = 0.0f, secondNumber = 0.0f, finalResult;
    String firstNumberString, secondNumberString;
    String operation;
    boolean firstNumberSet = false, operationSet = false, secondNumberSet = false, decimalSelected = false, equalSelected = false;

    /**
     * Parse result to first number and reset second number, result and operation
     */
    private void resetSecondNumberAndOperation() {

        firstNumber = finalResult;
        secondNumber = 0;
        secondNumberString = null;
        operation = null;
        operationSet = false;
        finalResult = 0;

    }

    /**
     * Calculate and display result
     */

    /**
     * Decimal option clicked
     */

    public void decimalClicked(View view) {
        decimalSelected = true;
    }

    /**
     * Calculate result
     */

    private void calculate() {
        String finalResultString;
        if (firstNumberSet && secondNumberSet && operationSet) {
            String helper = Double.toString(firstNumber) + " " + operation + " " + Double.toString(secondNumber);
            printHelper(helper);
            if (operation.equals("+")) {

                finalResult = firstNumber + secondNumber;
                finalResultString = Double.toString(finalResult);
                printResult(finalResultString);
                resetSecondNumberAndOperation();

            } else if (operation.equals("-")) {

                finalResult = firstNumber - secondNumber;
                finalResultString = Double.toString(finalResult);
                printResult(finalResultString);
                firstNumber = finalResult;
                resetSecondNumberAndOperation();

            } else if (operation.equals("X")) {

                finalResult = firstNumber * secondNumber;
                firstNumber = finalResult;
                finalResultString = Double.toString(finalResult);
                printResult(finalResultString);
                resetSecondNumberAndOperation();

            } else if (operation.equals("/")) {

                finalResult = firstNumber / secondNumber;
                finalResultString = Double.toString(finalResult);
                printResult(finalResultString);
                resetSecondNumberAndOperation();

            }
        }
    }

    /**
     * Calculate result and reset variables
     */

    public void equal(View view) {
        String finalResultString;
        if (firstNumberSet && secondNumberSet && operationSet) {
            String helper = Double.toString(firstNumber) + " " + operation + " " + Double.toString(secondNumber);
            printHelper(helper);
            if (operation.equals("+")) {

                finalResult = firstNumber + secondNumber;
                finalResultString = Double.toString(finalResult);
                printResult(finalResultString);
                resetSecondNumberAndOperation();

            } else if (operation.equals("-")) {

                finalResult = firstNumber - secondNumber;
                finalResultString = Double.toString(finalResult);
                printResult(finalResultString);
                firstNumber = finalResult;
                resetSecondNumberAndOperation();

            } else if (operation.equals("X")) {

                finalResult = firstNumber * secondNumber;
                firstNumber = finalResult;
                finalResultString = Double.toString(finalResult);
                printResult(finalResultString);
                resetSecondNumberAndOperation();

            } else if (operation.equals("/")) {

                finalResult = firstNumber / secondNumber;
                finalResultString = Double.toString(finalResult);
                printResult(finalResultString);
                resetSecondNumberAndOperation();

            }
            equalSelected = true;
            secondNumberSet = false;
        }

    }


    /**
     * Display Calculation result
     */
    private void printResult(String result) {

        TextView resultView = (TextView) findViewById(R.id.resultArea);
        resultView.setText(String.valueOf(result));
    }

    /**
     * Display helper
     */

    private void printHelper(String helper) {

        TextView resultView = (TextView) findViewById(R.id.helperText);
        resultView.setText(String.valueOf(helper));
    }

    /**
     * Set the number to the correct Variable
     */
    private void setNumbers(String content) {

        if (decimalSelected) {

            if (firstNumberSet) {

                if (secondNumberString != null) {
                    secondNumberString = secondNumberString + "." + content;
                } else {
                    secondNumberString = "0." + content;
                }
                secondNumber = Double.parseDouble(secondNumberString);
                printResult(secondNumberString);
                secondNumberSet = true;

            } else {

                if (firstNumberString != null) {
                    firstNumberString = firstNumberString + "." + content;
                } else {
                    firstNumberString = "0." + content;
                }
                firstNumber = Double.parseDouble(firstNumberString);
                printResult(firstNumberString);
            }

            decimalSelected = false;

        } else {

            if (firstNumberSet) {

                if (secondNumberString != null) {
                    secondNumberString = secondNumberString + content;
                } else {
                    secondNumberString = content;
                }
                secondNumber = Double.parseDouble(secondNumberString);
                printResult(secondNumberString);
                secondNumberSet = true;

            } else {

                if (firstNumberString != null) {
                    firstNumberString = firstNumberString + content;
                } else {
                    firstNumberString = content;
                }
                firstNumber = Double.parseDouble(firstNumberString);
                printResult(firstNumberString);
            }
        }


    }

    /**
     * Select the operation and set the firstNumberSet to true
     */
    public void operationSelect(View view) {
        equalSelected = false;
        if (!decimalSelected) {
            firstNumberSet = true;
            operationSet = true;
            if (operation == null || !secondNumberSet) {
                Button resultView = (Button) view;
                operation = resultView.getText().toString();
                String helper = Double.toString(firstNumber) + " " + operation;
                printHelper(helper);
            } else {

                calculate();
                Button resultView = (Button) view;
                operation = resultView.getText().toString();
                String helper = Double.toString(firstNumber) + " " + operation;
                printHelper(helper);
                firstNumberSet = true;
                operationSet = true;
            }
        }
    }

    /**
     * Erase the last digit
     */
    public void erase(View view) {
        int stringLength;
        if ((!decimalSelected || !equalSelected) && ((!firstNumberSet && !operationSet) || (operationSet && secondNumberSet))) {
            if (secondNumberString != null) {
                if ( secondNumberString.length() > 1) {
                    secondNumberString = secondNumberString.substring(0, secondNumberString.length() - 1);
                    secondNumber = Double.parseDouble(secondNumberString);
                    secondNumberSet = true;
                    printResult(secondNumberString);
                } else {
                    secondNumber = 0;
                    secondNumberString = null;
                    printResult(Double.toString(secondNumber));
                }

            } else if (firstNumberString != null) {
                if ( firstNumberString.length() > 1) {
                    firstNumberString = firstNumberString.substring(0, firstNumberString.length() - 1);
                    firstNumber = Double.parseDouble(firstNumberString);
                    printResult(firstNumberString);
                } else {
                    firstNumber = 0;
                    firstNumberString = null;
                    printResult(Double.toString(firstNumber));
                }

            } else {
                String finalResultString = Double.toString(finalResult);
                printResult(finalResultString);

            }
        }
    }

    /**
     * Calculate percentage
     */

    public void percentage(View view) {

        double middleNumber;
        String finalResultString;

        if (!secondNumberSet && operationSet) {

        } else if (!secondNumberSet && !operationSet) {

            firstNumber = firstNumber / 100;
            firstNumberString = Double.toString(firstNumber);
            printResult(firstNumberString);
        } else if (secondNumberSet && operationSet) {

            if (operation.equals("+")) {

                middleNumber = firstNumber / 100;
                secondNumber = middleNumber * secondNumber;
                finalResult = firstNumber + secondNumber;
                finalResultString = Double.toString(finalResult);
                printResult(finalResultString);
                resetSecondNumberAndOperation();

            } else if (operation.equals("-")) {

                middleNumber = firstNumber / 100;
                secondNumber = middleNumber * secondNumber;
                finalResult = firstNumber - secondNumber;
                finalResultString = Double.toString(finalResult);
                printResult(finalResultString);
                firstNumber = finalResult;
                resetSecondNumberAndOperation();

            } else if (operation.equals("X")) {

                middleNumber = 0.01;
                secondNumber = middleNumber * secondNumber;
                finalResult = firstNumber * secondNumber;
                firstNumber = finalResult;
                finalResultString = Double.toString(finalResult);
                printResult(finalResultString);
                resetSecondNumberAndOperation();

            } else if (operation.equals("/")) {

                middleNumber = 0.01;
                secondNumber = middleNumber * secondNumber;
                finalResult = firstNumber / secondNumber;
                finalResultString = Double.toString(finalResult);
                printResult(finalResultString);
                resetSecondNumberAndOperation();

            }


        }
    }

    /**
     * Reset Variables
     */
    private void silentReset() {
        firstNumber = 0;
        firstNumberString = null;
        firstNumberSet = false;

        secondNumber = 0;
        secondNumberString = null;
        secondNumberSet = false;

        operation = null;
        operationSet = false;
        finalResult = 0;

        equalSelected = false;

    }

    /**
     * Reset Variables and display 0
     */
    public void reset(View view) {
        firstNumber = 0;
        firstNumberString = null;
        firstNumberSet = false;

        secondNumber = 0;
        secondNumberString = null;
        secondNumberSet = false;

        operation = null;
        operationSet = false;
        finalResult = 0;
        String finalResultString = Double.toString(finalResult);
        printResult(finalResultString);
        printHelper(" ");
    }

    /**
     * Get the text of the button and place it to the Variable
     */
    public void getNumberFromText(View view) {
        if (equalSelected) {
            silentReset();
        }
        Button resultView = (Button) view;
        String textContent = resultView.getText().toString();
        setNumbers(textContent);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (firstNumber == 0.0f) {
            finalResult = 0;
            printResult("0");
        }
    }
}
