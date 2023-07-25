package com.example.simpleinterst;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextResult;
    private double operand1 = Double.NaN;
    private String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextResult = findViewById(R.id.editTextResult);
    }

    public void onDigitClick(View view) {
        Button button = (Button) view;
        editTextResult.append(button.getText().toString());
    }

    public void onDecimalClick(View view) {
        if (!editTextResult.getText().toString().contains(".")) {
            editTextResult.append(".");
        }
    }

    public void onOperatorClick(View view) {
        Button button = (Button) view;
        operator = button.getText().toString();
        operand1 = Double.parseDouble(editTextResult.getText().toString());
        editTextResult.setText("");
    }

    public void onClearClick(View view) {
        editTextResult.setText("");
        operand1 = Double.NaN;
        operator = "";
    }

    public void onPlusMinusClick(View view) {
        if (!editTextResult.getText().toString().isEmpty()) {
            double value = Double.parseDouble(editTextResult.getText().toString());
            editTextResult.setText(String.valueOf(-value));
        }
    }

    public void onPercentClick(View view) {
        if (!editTextResult.getText().toString().isEmpty()) {
            double value = Double.parseDouble(editTextResult.getText().toString()) / 100.0;
            editTextResult.setText(String.valueOf(value));
        }
    }

    public void onEqualsClick(View view) {
        if (!operator.isEmpty()) {
            String secondOperandStr = editTextResult.getText().toString();
            if (!secondOperandStr.isEmpty()) {
                double secondOperand = Double.parseDouble(secondOperandStr);
                double result = calculateResult(operand1, secondOperand, operator);
                editTextResult.setText(String.valueOf(result));
                operator = "";
                operand1 = Double.NaN;
            }
        }
    }

    private double calculateResult(double operand1, double operand2, String operator) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 == 0) {
                    return Double.NaN; // Division by zero
                }
                return operand1 / operand2;
            default:
                return Double.NaN; // Invalid operator
        }
    }
}
