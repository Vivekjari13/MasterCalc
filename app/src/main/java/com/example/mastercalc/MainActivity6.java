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

public class MainActivity6 extends AppCompatActivity {

    private EditText loanAmount, interest, time;
    private TextView totalAmount, totalPayableAmount, totalInterest;
    private Button calculate;
    private ImageView backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main6);
        initBinding();

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity6.this, MainActivity2.class);
                startActivity(intent);
            }
        });

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });
    }
    private void initBinding(){
        loanAmount = findViewById(R.id.loan);
        interest = findViewById(R.id.rate);
        time = findViewById(R.id.TimePeriod);
        totalAmount = findViewById(R.id.totalAmount);
        totalPayableAmount = findViewById(R.id.totalPayableAmount);
        totalInterest = findViewById(R.id.totalInterest);
        calculate = findViewById(R.id.calculate);
        backButton = findViewById(R.id.backButton);
    }

    private void calculate(){
        String amount = loanAmount.getText().toString();
        String rate = interest.getText().toString();
        String period = time.getText().toString();

        if (amount.isEmpty()) {
            loanAmount.setError("Enter Your Amount");
            return;
        } else if (rate.isEmpty()) {
            interest.setError("Enter Your Interest");
            return;
        } else if (period.isEmpty()) {
            time.setError("Enter Your Year");
            return;
        }else {

            double amount1 = Double.parseDouble(loanAmount.getText().toString());
            double interest1 = Double.parseDouble(interest.getText().toString());
            double year1 = Double.parseDouble(time.getText().toString());

            double monthlyInterestRate = (interest1/12)/100;
            double numberOfPayments = year1 * 12;
            double emi = amount1 * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments) / ( Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);
            totalAmount.setText(String.valueOf((int) emi));
            totalInterest.setText(String.valueOf((int)((emi*numberOfPayments)-amount1)));
            totalPayableAmount.setText(String.valueOf((int)(emi*numberOfPayments)));

        }
    }

}