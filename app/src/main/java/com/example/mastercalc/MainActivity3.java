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


public class MainActivity3 extends AppCompatActivity {
    private EditText invest,Return,timePeriods;
    private ImageView backButton;
    private Button calculateButton;
    private TextView totalInvest1,estReturn,totalValues;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        initBinding();

        //For back Button

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // intent

                Intent intent = new Intent(MainActivity3.this, MainActivity2.class);
                startActivity(intent);
            }
        });

        // For Calculation

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
            }
        });


    }

    private void initBinding(){
        backButton = findViewById(R.id.backButton);
        invest = findViewById(R.id.Invest);
        Return = findViewById(R.id.Return);
        timePeriods = findViewById(R.id.Time);
        totalInvest1 = findViewById(R.id.Invested);
        estReturn = findViewById(R.id.Est);
        totalValues = findViewById(R.id.Total);
        calculateButton = findViewById(R.id.Calculate);
    }
    private void  calculate(){
        String amount = invest.getText().toString();
        String interest = Return.getText().toString();
        String year = timePeriods.getText().toString();

        if (amount.isEmpty()) {
            invest.setError("Enter Your Amount");
            return;
        } else if (interest.isEmpty()) {
            Return.setError("Enter Your Interest");
            return;
        } else if (year.isEmpty()) {
            timePeriods.setError("Enter Your Year");
            return;
        }

        try {
            double amount1 = Double.parseDouble(amount);
            double interest1 = Double.parseDouble(interest);
            double year1 = Double.parseDouble(year);

            double monthlyRate = interest1 / 12 / 100;
            double numberOfPayments = year1 * 12;

            // Correcting the formula for SIP calculation
            double sipAmount = amount1 * ((Math.pow(1 + monthlyRate, numberOfPayments) - 1) / monthlyRate) * (1 + monthlyRate);

            double totalInvested = amount1 * numberOfPayments;
            double totalReturns = sipAmount * numberOfPayments - totalInvested;
            double totalValue = sipAmount * numberOfPayments;

            totalInvest1.setText(String.format("%.2f", totalInvested));
            estReturn.setText(String.format("%.2f", totalReturns));
            totalValues.setText(String.format("%.2f", totalValue));
        } catch (NumberFormatException e) {
            invest.setError("Invalid input");
            Return.setError("Invalid input");
            timePeriods.setError("Invalid input");
        }
    }

}