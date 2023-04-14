package com.example.hospitalmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.hospitalmanagement.R;

public class MainActivity extends AppCompatActivity {

    EditText nameInput, ageInput, illnessInput;
    TextView displayText;
    String[] patientNames = new String[100];
    int[] patientAges = new int[100];
    String[] patientIllnesses = new String[100];
    int patientCount = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameInput = findViewById(R.id.name_input);
        ageInput = findViewById(R.id.age_input);
        illnessInput = findViewById(R.id.illness_input);
        displayText = findViewById(R.id.display_text);
    }

    public void addPatient(View view) {
        String name = nameInput.getText().toString();
        int age = Integer.parseInt(ageInput.getText().toString());
        String illness = illnessInput.getText().toString();
        patientNames[patientCount] = name;
        patientAges[patientCount] = age;
        patientIllnesses[patientCount] = illness;
        patientCount++;
        displayText.setText("Patient added successfully!");
    }

    public void displayPatients(View view) {
        if (patientCount == 0) {
            displayText.setText("No patients found.");
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < patientCount; i++) {
                sb.append("Patient Name: ").append(patientNames[i]).append("\n");
                sb.append("Patient Age: ").append(patientAges[i]).append("\n");
                sb.append("Patient Illness: ").append(patientIllnesses[i]).append("\n\n");
            }
            displayText.setText(sb.toString());
        }
    }
}
