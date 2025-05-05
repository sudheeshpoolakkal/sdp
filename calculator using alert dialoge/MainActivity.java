package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;

public class MainActivity extends AppCompatActivity {

    private Button showCalculatorButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showCalculatorButton = findViewById(R.id.showCalculatorButton);

        showCalculatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCalculatorDialog();
            }
        });
    }

    private void showCalculatorDialog() {
        final EditText num1Input = new EditText(MainActivity.this);
        final EditText num2Input = new EditText(MainActivity.this);

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Calculator")
                .setMessage("Enter first number:")
                .setView(num1Input)
                .setPositiveButton("Next", null)
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

        final AlertDialog dialog = builder.create();
        dialog.show();

        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double num1 = Double.parseDouble(num1Input.getText().toString());

                    final String[] operations = {"+", "-", "*", "/"};
                    AlertDialog.Builder operationDialog = new AlertDialog.Builder(MainActivity.this);
                    operationDialog.setTitle("Select an Operation")
                            .setItems(operations, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    String operator = operations[which];

                                    builder.setMessage("Enter second number:")
                                            .setView(num2Input)
                                            .setPositiveButton("Calculate", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    try {
                                                        double num2 = Double.parseDouble(num2Input.getText().toString());
                                                        double result = performCalculation(num1, num2, operator);
                                                        Toast.makeText(MainActivity.this, "Result: " + result, Toast.LENGTH_SHORT).show();
                                                    } catch (NumberFormatException e) {
                                                        Toast.makeText(MainActivity.this, "Invalid number", Toast.LENGTH_SHORT).show();
                                                    }
                                                }
                                            })
                                            .setNegativeButton("Cancel", null)
                                            .show();
                                }
                            })
                            .show();
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Invalid number", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private double performCalculation(double num1, double num2, String operator) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    Toast.makeText(MainActivity.this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                    return 0;
                }
            default:
                return 0;
        }
    }
}
