package com.example.volleyballscorer;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText homeScore, awayScore;
    private Button addBtnHome, removeBtnHome, addBtnAway, removeBtnAway;
    private TextView servingTeam;
    private boolean isHomeServing = true; // Home starts serving by default

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homeScore = findViewById(R.id.homeScore);
        awayScore = findViewById(R.id.awayScore);
        addBtnHome = findViewById(R.id.addBtnHome);
        removeBtnHome = findViewById(R.id.removeBtnHome);
        addBtnAway = findViewById(R.id.addBtnAway);
        removeBtnAway = findViewById(R.id.removeBtnAway);
        servingTeam = findViewById(R.id.servingTeam);

        updateServingTeam();

        addBtnHome.setOnClickListener(v -> updateScore(true));
        removeBtnHome.setOnClickListener(v -> removeScore(true));
        addBtnAway.setOnClickListener(v -> updateScore(false));
        removeBtnAway.setOnClickListener(v -> removeScore(false));
    }

    // Update the score based on which team scored and check if the serve should switch
    private void updateScore(boolean isHomeScoring) {
        int home = Integer.parseInt(homeScore.getText().toString());
        int away = Integer.parseInt(awayScore.getText().toString());

        if (isHomeScoring) {
            if (isHomeServing) {
                home++; // Home scores while serving, continues to serve
            } else {
                home++; // Home scores while receiving, takes over the serve
                isHomeServing = true;
            }
        } else {
            if (!isHomeServing) {
                away++; // Away scores while serving, continues to serve
            } else {
                away++; // Away scores while receiving, takes over the serve
                isHomeServing = false;
            }
        }

        homeScore.setText(String.valueOf(home));
        awayScore.setText(String.valueOf(away));

        updateServingTeam();

        // Check for match point (first to 25 and must lead by 2)
        if (checkMatchPoint(home, away)) {
            Toast.makeText(this, (home > away ? "Home" : "Away") + " wins!", Toast.LENGTH_SHORT).show();
        }
    }

    // Remove points (with a lower bound of 0)
    private void removeScore(boolean isHome) {
        int home = Integer.parseInt(homeScore.getText().toString());
        int away = Integer.parseInt(awayScore.getText().toString());

        if (isHome) {
            home = Math.max(home - 1, 0);
            homeScore.setText(String.valueOf(home));
        } else {
            away = Math.max(away - 1, 0);
            awayScore.setText(String.valueOf(away));
        }
    }

    // Update the serving team text view
    private void updateServingTeam() {
        servingTeam.setText(isHomeServing ? "Home is serving" : "Away is serving");
    }

    // Check for match point (first to 25 with 2-point lead)
    private boolean checkMatchPoint(int home, int away) {
        if ((home >= 25 || away >= 25) && Math.abs(home - away) >= 2) {
            return true; // Match point reached
        }
        return false;
    }
}
