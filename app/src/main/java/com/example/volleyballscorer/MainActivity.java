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
    private TextView servingTeam, position1_set1, position2_set1, position3_set1, position4_set1, position5_set1, position6_set1;
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
        position1_set1 = findViewById(R.id.position1_set1);
        position2_set1 = findViewById(R.id.position2_set1);
        position3_set1 = findViewById(R.id.position3_set1);
        position4_set1 = findViewById(R.id.position4_set1);
        position5_set1 = findViewById(R.id.position5_set1);
        position6_set1 = findViewById(R.id.position6_set1);

        position1_set1.setOnClickListener(this);
        position2_set1.setOnClickListener(this);
        position3_set1.setOnClickListener(this);
        position4_set1.setOnClickListener(this);
        position5_set1.setOnClickListener(this);
        position6_set1.setOnClickListener(this);

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

        position1_set1.setText(String.valueOf(playerPositions[0]));
        position2_set1.setText(String.valueOf(playerPositions[1]));
        position3_set1.setText(String.valueOf(playerPositions[2]));
        position4_set1.setText(String.valueOf(playerPositions[3]));
        position5_set1.setText(String.valueOf(playerPositions[4]));
        position6_set1.setText(String.valueOf(playerPositions[5]));
    }

    @Override
    public void onClick(View v) {
        // Handle clicks on player number views to allow input
        switch (v.getId()) {
            case R.id.position1_set1:
                // Show dialog or input for editing player number 1
                break;
            case R.id.position2_set1:
                // Show dialog or input for editing player number 2
                break;
            case R.id.position3_set1:
                // Show dialog or input for editing player number 3
                break;
            case R.id.position4_set1:
                // Show dialog or input for editing player number 4
                break;
            case R.id.position5_set1:
                // Show dialog or input for editing player number 5
                break;
            case R.id.position6_set1:
                // Show dialog or input for editing player number 6
                break;

            case R.id.position1_set2:
                // Show dialog or input for editing player number 1
                break;
            case R.id.position2_set2:
                // Show dialog or input for editing player number 2
                break;
            case R.id.position3_set2:
                // Show dialog or input for editing player number 3
                break;
            case R.id.position4_set2:
                // Show dialog or input for editing player number 4
                break;
            case R.id.position5_set2:
                // Show dialog or input for editing player number 5
                break;
            case R.id.position6_set2:
                // Show dialog or input for editing player number 6
                break;
       }
    }
}
