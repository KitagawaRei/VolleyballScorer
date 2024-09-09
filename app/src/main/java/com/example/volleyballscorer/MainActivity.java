package com.example.volleyballscorer;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Declare variables for the buttons and EditText
    Button addBtn, removeBtn;
    EditText itemQuanEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Ensure this matches your layout file

        // Initialize the views by finding them by their ID
        addBtn = findViewById(R.id.addBtn);
        removeBtn = findViewById(R.id.removeBtn);
        itemQuanEt = findViewById(R.id.itemQuanEt);

        // Set the initial value in the EditText (if not set in XML)
        itemQuanEt.setText("1");

        // Set an OnClickListener for the Add Button to increment the value
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the current value from the EditText
                String currentValStr = itemQuanEt.getText().toString();

                // Parse it to an integer
                int currentValue = Integer.parseInt(currentValStr);

                // Increment the value
                currentValue++;

                // Set the updated value back to the EditText
                itemQuanEt.setText(String.valueOf(currentValue));
            }
        });

        // Set an OnClickListener for the Remove Button to decrement the value
        removeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the current value from the EditText
                String currentValStr = itemQuanEt.getText().toString();

                // Parse it to an integer
                int currentValue = Integer.parseInt(currentValStr);

                // Decrement the value, but ensure it doesn't go below 1
                if (currentValue > 1) {
                    currentValue--;
                } else {
                    // Optional: Show a message if user tries to go below 1
                    Toast.makeText(MainActivity.this, "Quantity can't be less than 1", Toast.LENGTH_SHORT).show();
                }

                // Set the updated value back to the EditText
                itemQuanEt.setText(String.valueOf(currentValue));
            }
        });
    }
}
