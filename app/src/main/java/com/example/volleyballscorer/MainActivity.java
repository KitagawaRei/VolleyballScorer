package com.example.volleyballscorer;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Declare variables for HOME and AWAY buttons and EditTexts
    Button addBtnHome, removeBtnHome, addBtnAway, removeBtnAway;
    EditText homeScore, awayScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize HOME team views
        addBtnHome = findViewById(R.id.addBtnHome);
        removeBtnHome = findViewById(R.id.removeBtnHome);
        homeScore = findViewById(R.id.homeScore);

        // Initialize AWAY team views
        addBtnAway = findViewById(R.id.addBtnAway);
        removeBtnAway = findViewById(R.id.removeBtnAway);
        awayScore = findViewById(R.id.awayScore);

        // Set initial values for both teams
        homeScore.setText("0");
        awayScore.setText("0");

        // Add Button for HOME team
        addBtnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentHomeScore = Integer.parseInt(homeScore.getText().toString());
                currentHomeScore++;
                homeScore.setText(String.valueOf(currentHomeScore));
            }
        });

        // Remove Button for HOME team
        removeBtnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentHomeScore = Integer.parseInt(homeScore.getText().toString());
                if (currentHomeScore > 0) {
                    currentHomeScore--;
                } else {
                    Toast.makeText(MainActivity.this, "Score can't be less than 0", Toast.LENGTH_SHORT).show();
                }
                homeScore.setText(String.valueOf(currentHomeScore));
            }
        });

        // Add Button for AWAY team
        addBtnAway.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentAwayScore = Integer.parseInt(awayScore.getText().toString());
                currentAwayScore++;
                awayScore.setText(String.valueOf(currentAwayScore));
            }
        });

        // Remove Button for AWAY team
        removeBtnAway.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentAwayScore = Integer.parseInt(awayScore.getText().toString());
                if (currentAwayScore > 0) {
                    currentAwayScore--;
                } else {
                    Toast.makeText(MainActivity.this, "Score can't be less than 0", Toast.LENGTH_SHORT).show();
                }
                awayScore.setText(String.valueOf(currentAwayScore));
            }
        });
    }
}
