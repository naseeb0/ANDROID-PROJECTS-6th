package com.example.simpleinterst;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button calculateButton = findViewById(R.id.buttonCalculate);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInputDialog();
            }
        });
    }

    private void showInputDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_input);
        dialog.setTitle("Rectangle Calculator");

        final EditText editTextLength = dialog.findViewById(R.id.editTextLength);
        final EditText editTextWidth = dialog.findViewById(R.id.editTextWidth);
        Button calculateButton = dialog.findViewById(R.id.buttonCalculate);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double length = Double.parseDouble(editTextLength.getText().toString());
                double width = Double.parseDouble(editTextWidth.getText().toString());

                double area = length * width;
                double perimeter = 2 * (length + width);

                showResultDialog(area, perimeter);
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    private void showResultDialog(double area, double perimeter) {
        Dialog resultDialog = new Dialog(this);
        resultDialog.setContentView(R.layout.dialog_result);
        resultDialog.setTitle("Result");

        TextView textViewArea = resultDialog.findViewById(R.id.textViewArea);
        TextView textViewPerimeter = resultDialog.findViewById(R.id.textViewPerimeter);

        textViewArea.setText("Area: " + area);
        textViewPerimeter.setText("Perimeter: " + perimeter);

        resultDialog.show();
    }
}
