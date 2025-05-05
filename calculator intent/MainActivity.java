package com.example.intentcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etNumber1, etNumber2;
    private Button btnAdd, btnSubtract, btnMultiply, btnDivide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Layout file for MainActivity

        etNumber1 = findViewById(R.id.etNumber1);
        etNumber2 = findViewById(R.id.etNumber2);
        btnAdd = findViewById(R.id.btnAdd);
        btnSubtract = findViewById(R.id.btnSubtract);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnDivide = findViewById(R.id.btnDivide);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchCalculator("+");
            }
        });

        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchCalculator("-");
            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchCalculator("*");
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchCalculator("/");
            }
        });
    }

    private void launchCalculator(String operator) {
        String strNum1 = etNumber1.getText().toString();
        String strNum2 = etNumber2.getText().toString();

        if (strNum1.isEmpty() || strNum2.isEmpty()) {
            // Optionally, show an error message here
            return;
        }

        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);

        // Create an intent to start CalculatorActivity
        Intent intent = new Intent(MainActivity.this, CalculatorActivity.class);
        intent.putExtra("num1", num1);
        intent.putExtra("num2", num2);
        intent.putExtra("operator", operator);
        startActivity(intent);
    }
}
