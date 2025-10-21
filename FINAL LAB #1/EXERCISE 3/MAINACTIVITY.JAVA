package com.example.finallab1;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        AutoCompleteTextView autoCountry = findViewById(R.id.auto_country);
        String[] countries = {"Philippines", "Japan", "Canada", "Australia", "United States"};
        ArrayAdapter<String> countryAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_dropdown_item_1line, countries);
        autoCountry.setAdapter(countryAdapter);


        Spinner spinner = findViewById(R.id.spinner_options);
        String[] options = {"JAVA", "KOTLIN", "SWIFT", "FLUTTER", "REACT NATIVE"};
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, options);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
    }
}
