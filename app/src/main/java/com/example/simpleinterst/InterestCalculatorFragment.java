package com.example.simpleinterst;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class InterestCalculatorFragment extends Fragment {

    private EditText editTextPrincipal;
    private EditText editTextInterestRate;
    private EditText editTextTimePeriod;
    private TextView textViewResult;

    public InterestCalculatorFragment() {
        
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        
        View rootView = inflater.inflate(R.layout.fragment_interest_calculator, container, false);

        editTextPrincipal = rootView.findViewById(R.id.editTextPrincipal);
        editTextInterestRate = rootView.findViewById(R.id.editTextInterestRate);
        editTextTimePeriod = rootView.findViewById(R.id.editTextTimePeriod);
        textViewResult = rootView.findViewById(R.id.textViewResult);

        Button buttonCalculate = rootView.findViewById(R.id.buttonCalculate);
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateInterest();
            }
        });

        return rootView;
    }

    private void calculateInterest() {
        double principal = Double.parseDouble(editTextPrincipal.getText().toString());
        double interestRate = Double.parseDouble(editTextInterestRate.getText().toString());
        double timePeriod = Double.parseDouble(editTextTimePeriod.getText().toString());

        double simpleInterest = (principal * interestRate * timePeriod) / 100.0;
        textViewResult.setText(String.format("Simple Interest: %.2f", simpleInterest));
    }
}
