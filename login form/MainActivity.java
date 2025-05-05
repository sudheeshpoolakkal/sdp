package com.example.loginform;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText usernameEditText, passwordEditText;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI elements
        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);

        // Handle login button click
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the values entered in EditTexts
                String username = usernameEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                // Check for valid input (here, it's just a basic check for simplicity)
                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter both username and password", Toast.LENGTH_SHORT).show();
                } else {
                    // Show alert dialog to simulate login process
                    showLoginDialog(username, password);
                }
            }
        });
    }

    // Function to show the AlertDialog for successful login
    private void showLoginDialog(final String username, final String password) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Login Attempt");

        // Assuming correct username and password are "admin" and "password"
        if (username.equals("admin") && password.equals("password")) {
            builder.setMessage("Login Successful! Welcome, " + username);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MainActivity.this, "Logged in as " + username, Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            builder.setMessage("Login Failed! Invalid username or password.");
            builder.setPositiveButton("Retry", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // Nothing to do here, just retrying
                }
            });
        }

        builder.show();
    }
}
