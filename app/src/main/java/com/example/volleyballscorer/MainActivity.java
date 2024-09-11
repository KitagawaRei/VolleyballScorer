package com.example.volleyballscorer;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText homeScore, awayScore;
    private Button addBtnHome, removeBtnHome, addBtnAway, removeBtnAway;
    private TextView servingTeam, p1, p2, p3, p4, p5, p6;
    private boolean isHomeServing = true; // Home starts serving by default
    private int[] playerPositions = {1, 2, 3, 4, 5, 6}; // Initialize player positions

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
        p1 = findViewById(R.id.p1);
        p2 = findViewById(R.id.p2);
        p3 = findViewById(R.id.p3);
        p4 = findViewById(R.id.p4);
        p5 = findViewById(R.id.p5);
        p6 = findViewById(R.id.p6);

        p1.setOnClickListener(this);
        p2.setOnClickListener(this);
        p3.setOnClickListener(this);
        p4.setOnClickListener(this);
        p5.setOnClickListener(this);
        p6.setOnClickListener(this);

        updateServingTeam();

        addBtnHome.setOnClickListener(v -> updateScore(true));
        removeBtnHome.setOnClickListener(v -> removeScore(true));
        addBtnAway.setOnClickListener(v -> updateScore(false));
        removeBtnAway.setOnClickListener(v -> removeScore(false));
    }

    private void updateScore(boolean isHomeScoring) {
        int home = Integer.parseInt(homeScore.getText().toString());
        int away = Integer.parseInt(awayScore.getText().toString());

        if (isHomeScoring) {
            if (isHomeServing) {
                home++;
            } else {
                home++;
                isHomeServing = true;
                rotatePlayers();
            }
        } else {
            if (!isHomeServing) {
                away++;
            } else {
                away++;
                isHomeServing = false;
                rotatePlayers();
            }
        }

        homeScore.setText(String.valueOf(home));
        awayScore.setText(String.valueOf(away));

        updateServingTeam();

        if (checkMatchPoint(home, away)) {
            Toast.makeText(this, (home > away ? "Home" : "Away") + " wins!", Toast.LENGTH_SHORT).show();
        }
    }

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

    private void updateServingTeam() {
        servingTeam.setText(isHomeServing ? "Home is serving" : "Away is serving");
    }

    private boolean checkMatchPoint(int home, int away) {
        return (home >= 25 || away >= 25) && Math.abs(home - away) >= 2;
    }

    private void rotatePlayers() {
        int temp = playerPositions[0];
        System.arraycopy(playerPositions, 1, playerPositions, 0, playerPositions.length - 1);
        playerPositions[playerPositions.length - 1] = temp;

        p1.setText(String.valueOf(playerPositions[0]));
        p2.setText(String.valueOf(playerPositions[1]));
        p3.setText(String.valueOf(playerPositions[2]));
        p4.setText(String.valueOf(playerPositions[3]));
        p5.setText(String.valueOf(playerPositions[4]));
        p6.setText(String.valueOf(playerPositions[5]));
    }

    @Override
    public void onClick(View v) {
        // Handle clicks on player number views to allow input
        switch (v.getId()) {
            case R.id.p1:
                // Show dialog or input for editing player number 1
                break;
            case R.id.p2:
                // Show dialog or input for editing player number 2
                break;
            case R.id.p3:
                // Show dialog or input for editing player number 3
                break;
            case R.id.p4:
                // Show dialog or input for editing player number 4
                break;
            case R.id.p5:
                // Show dialog or input for editing player number 5
                break;
            case R.id.p6:
                // Show dialog or input for editing player number 6
                break;
        }
    }

}
