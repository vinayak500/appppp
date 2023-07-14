package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class donation extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText name, address, amount;
    Spinner option;
    Button donatebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation);
        name = findViewById(R.id.nameEditText);
        address = findViewById(R.id.addressEditText);
        amount = findViewById(R.id.payment);
        option = findViewById(R.id.donationSpinner);
        donatebtn = findViewById(R.id.donateButton);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.donation_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        option.setAdapter(adapter);
        option.setOnItemSelectedListener(this);
        donatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text_name = name.getText().toString().trim();
                String text_address = address.getText().toString().trim();
                String text_amount = amount.getText().toString().trim();
                String text_option = option.getSelectedItem().toString();
                FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                String username = getIntent().getStringExtra("email");
                DatabaseReference databaseReference = firebaseDatabase.getReference("donated").child(username);
                UserHelperClass helperClass = new UserHelperClass(text_name, text_address, text_option, text_amount);
                databaseReference.setValue(helperClass);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (position == 0) {
            Toast.makeText(donation.this,"cant select the option",Toast.LENGTH_SHORT).show();

            // The first option is selected, perform any necessary actions or show a message
        } else {
            // Option other than the first one is selected
            String selectedOption = parent.getItemAtPosition(position).toString();
            // Perform the desired actions based on the selected option
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // Handle the case when nothing is selected (if needed)
    }
}


