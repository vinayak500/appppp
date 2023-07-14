package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class history extends AppCompatActivity {
    private RecyclerView historyRecyclerView;
    private HistoryAdapter historyAdapter;
    private DatabaseReference historyReference;
    private List<HistoryEntry> historyList;

    ImageButton back;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(history.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        historyRecyclerView = findViewById(R.id.historyRecyclerView);
        historyRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        String username = getIntent().getStringExtra("email");

        // Initialize Firebase reference
        historyReference = FirebaseDatabase.getInstance().getReference("pooja").child(username);

        // Initialize history list
        historyList = new ArrayList<>();

        // Set up the adapter for the RecyclerView
        historyAdapter = new HistoryAdapter(historyList);
        historyRecyclerView.setAdapter(historyAdapter);

        // Retrieve history data from Firebase
        historyReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // Clear previous entries
                historyList.clear();

                // Iterate through the dataSnapshot to get individual entries
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    // Extract the data from the snapshot

                    String nakshatra = snapshot.child("nakshatra").getValue(String.class);
                    String rashi = snapshot.child("rashi").getValue(String.class);
                    String selectedOption = snapshot.child("selectedOption").getValue(String.class);
                    String selectedDate = snapshot.child("selectedDate").getValue(String.class);
                    String yourName = snapshot.child("yourName").getValue(String.class);
                    String poojaname = snapshot.child("poojaname").getValue(String.class);
                    String price = snapshot.child("price").getValue(String.class);

                    // Create a new HistoryEntry object
                    HistoryEntry historyEntry = new HistoryEntry(yourName, nakshatra, rashi, selectedOption, selectedDate, poojaname, price);

                    // Add the entry to the history list
                    historyList.add(historyEntry);
                }

                // Notify the adapter that the data has changed
                historyAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle database error if needed
            }
        });
    }
}
