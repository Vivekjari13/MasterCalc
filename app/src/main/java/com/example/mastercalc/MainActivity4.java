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


public class MainActivity4 extends AppCompatActivity {

    private EditText principal, interest, total;
    private TextView invested;
    private Button calculate;
    private ImageView backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main4);
        initBinding();

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity4.this, MainActivity2.class);
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
        principal = findViewById(R.id.Principal);
        interest = findViewById(R.id.InterestRate);
        total = findViewById(R.id.Total);
        invested = findViewById(R.id.Invested);
        calculate = findViewById(R.id.Calculate);
        backButton = findViewById(R.id.backButton);

    }

    private void calculate(){
        String amount1 = principal.getText().toString();
        String interest1 = interest.getText().toString();
        String time = total.getText().toString();

        if (amount1.isEmpty()) {
            principal.setError("Enter Your Amount");
            return;
        } else if (interest1.isEmpty()) {
            interest.setError("Enter Your Interest");
            return;
        } else if (time.isEmpty()) {
            total.setError("Enter Your Year");
            return;
        }

        double Invest = Double.parseDouble(amount1) * Double.parseDouble(interest1) * Double.parseDouble(time);
        invested.setText(String.format("%.3f", Invest));
    }
}