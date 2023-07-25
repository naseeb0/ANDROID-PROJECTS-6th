package com.example.simpleinterst;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextPatientName, editTextAge, editTextPhoneNumber, editTextAddress, editTextMedicalHistory;
    private RadioGroup radioGroupGender;
    private Spinner spinnerBloodGroup;
    private Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find views by their IDs
        editTextPatientName = findViewById(R.id.editTextPatientName);
        editTextAge = findViewById(R.id.editTextAge);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber);
        editTextAddress = findViewById(R.id.editTextAddress);
        spinnerBloodGroup = findViewById(R.id.spinnerBloodGroup);
        editTextMedicalHistory = findViewById(R.id.editTextMedicalHistory);
        buttonRegister = findViewById(R.id.buttonRegister);

        // Handle button click to register the patient
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerPatient();
            }
        });
    }

    // Register the patient
    private void registerPatient() {
        String patientName = editTextPatientName.getText().toString();
        int age = Integer.parseInt(editTextAge.getText().toString());
        String gender = ((RadioButton) findViewById(radioGroupGender.getCheckedRadioButtonId())).getText().toString();
        String phoneNumber = editTextPhoneNumber.getText().toString();
        String address = editTextAddress.getText().toString();
        String bloodGroup = spinnerBloodGroup.getSelectedItem().toString();
        String medicalHistory = editTextMedicalHistory.getText().toString();

        // Implement your logic here to register the patient in the hospital
        // For simplicity, we'll just show a Toast message indicating the registration is successful
        String message = "Patient Registered: " + patientName;
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
