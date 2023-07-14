package com.example.myapplication;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Timing extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
     TextView selectedDateTextView;
     Spinner optionsSpinner;
     Calendar calendar;
    Button saveButton;
    TextView pooja;
    TextView price;
    EditText yourNameEditText;
    EditText nakshatraEditText;
    EditText rashiEditText;

    private DatabaseReference databaseReference;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timing);
        String poojaname = getIntent().getStringExtra("pooja");
        pooja = findViewById(R.id.name);
        pooja.setText("Poooja Name : " + poojaname);
        String price_a = getIntent().getStringExtra("Price");
        price = findViewById(R.id.price);
        price.setText("amount to be paid: " + price_a + "rs");


        selectedDateTextView = findViewById(R.id.selectedDateTextView);
        calendar = Calendar.getInstance();
        optionsSpinner = findViewById(R.id.optionsSpinner);
        yourNameEditText = findViewById(R.id.yourname);
        nakshatraEditText = findViewById(R.id.uploadTopic);
        rashiEditText = findViewById(R.id.uploadDesc);
        saveButton = findViewById(R.id.saveButton);

        // Create an ArrayAdapter with the options and a default layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.options_array, android.R.layout.simple_spinner_item);

        // Specify the layout for the dropdown list
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Set the adapter to the spinner
        optionsSpinner.setAdapter(adapter);

        // Set the listener for item selection
        optionsSpinner.setOnItemSelectedListener(this);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = getIntent().getStringExtra("email");
                FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                databaseReference = firebaseDatabase.getReference("pooja");
                String selectedOption = optionsSpinner.getSelectedItem().toString();

                String yourName = yourNameEditText.getText().toString().trim();
                String nakshatra = nakshatraEditText.getText().toString().trim();
                String rashi = rashiEditText.getText().toString().trim();
                String selectedDate = selectedDateTextView.getText().toString();

                // Create a new data object
                DataObject dataObject = new DataObject("email", yourName, nakshatra, rashi, selectedOption, selectedDate, price_a, poojaname);
                databaseReference.child(email).push().setValue(dataObject);



                Toast.makeText(Timing.this, "Data saved successfully", Toast.LENGTH_SHORT).show();
            }

        });


    }

    public void onPickDateButtonClick(View view) {
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                updateSelectedDateTextView();
            }
        }, year, month, day);

        datePickerDialog.show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String selectedOption = parent.getItemAtPosition(position).toString();
        Toast.makeText(this, "Selected Option: " + selectedOption, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // Do nothing
    }

    public void updateSelectedDateTextView() {
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
        String selectedDate = dateFormat.format(calendar.getTime());
        selectedDateTextView.setText("Date: " + selectedDate);
    }



}
