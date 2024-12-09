package com.example.mastercalc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity8 extends AppCompatActivity {

    private ImageView backButton;
    private TextView SquareResult;
    private EditText inputNumber, addSquareOrHour;
    private Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main8);
        initBinding();

        //For back Button

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // intent

                Intent intent = new Intent(MainActivity8.this, MainActivity2.class);
                startActivity(intent);
            }
        });
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
            }
        });
    }

    public void initBinding() {
        backButton = findViewById(R.id.backButton);
        SquareResult = findViewById(R.id.result);
        inputNumber = findViewById(R.id.number);
        addSquareOrHour = findViewById(R.id.square);
        calculateButton = findViewById(R.id.calculate);
    }

    public void calculate() {

        String inputStr = inputNumber.getText().toString();
        String squareOrHourStr = addSquareOrHour.getText().toString();

        if (inputStr.isEmpty()) {
            inputNumber.setError("Enter Input");
        } else if (squareOrHourStr.isEmpty()) {
            addSquareOrHour.setError("Enter Hour Or Square");
        } else {
            double input = Double.parseDouble(inputStr);
            double squareOrHour = Double.parseDouble(squareOrHourStr);
            double square = Math.pow(input, squareOrHour);
            SquareResult.setText(String.format("%d", (int) square));
        }
    }
}