package com.example.intentcalculator;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class CalculatorActivity extends AppCompatActivity {

    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator); // Layout file for CalculatorActivity

        tvResult = findViewById(R.id.tvResult);

        // Retrieve data from the intent
        double num1 = getIntent().getDoubleExtra("num1", 0);
        double num2 = getIntent().getDoubleExtra("num2", 0);
        String operator = getIntent().getStringExtra("operator");

        double result = 0;
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;

            case "-":
                result = num1 - num2;
                break;

            case "*":
                result = num1 * num2;
                break;

            case "/":
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    tvResult.setText("Error: Division by zero");
                    return;
                }
                break;

            default:
                tvResult.setText("Invalid operator");
                return;
        }

        tvResult.setText("Result: " + result);
    }
}
