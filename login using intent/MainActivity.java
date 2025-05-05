package com.example.login2;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView tvWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvWelcome = findViewById(R.id.tvWelcome);

        // Retrieve the username from the intent extras
        String username = getIntent().getStringExtra("username");

        // Display a welcome message
        tvWelcome.setText("Welcome, " + username + "!");
    }
}
