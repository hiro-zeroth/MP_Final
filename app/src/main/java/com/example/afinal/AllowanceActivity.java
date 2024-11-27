package com.example.afinal;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class AllowanceActivity extends AppCompatActivity {

    private EditText amountInput;
    private Spinner frequencySpinner;
    private DatePicker datePicker;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.allowance_activity_layout);

        amountInput = findViewById(R.id.amountInput);
        frequencySpinner = findViewById(R.id.frequencySpinner);
        datePicker = findViewById(R.id.datePicker);
        submitButton = findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleFormSubmission();
            }
        });

        setupFrequencySpinner();
    }

    private void setupFrequencySpinner() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.frequency_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        frequencySpinner.setAdapter(adapter);
    }

    private void handleFormSubmission() {
        String amount = amountInput.getText().toString().trim();
        String frequency = frequencySpinner.getSelectedItem().toString();

        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year = datePicker.getYear();
        Calendar selectedDate = Calendar.getInstance();
        selectedDate.set(year, month, day);

        if (amount.isEmpty()) {
            Toast.makeText(this, "Please enter an allowance amount", Toast.LENGTH_SHORT).show();
            return;
        }

        String confirmationMessage = String.format("Allowance of %s is set %s starting on %tF", amount, frequency, selectedDate);
        Toast.makeText(this, confirmationMessage, Toast.LENGTH_LONG).show();

        // mga dbases
    }
}
