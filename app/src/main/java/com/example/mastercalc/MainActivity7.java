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

public class MainActivity7 extends AppCompatActivity {

    private EditText marks, yourMarks;
    private Button calculate;
    private ImageView backButton;
    private TextView percent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main7);
        initBinding();

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity7.this, MainActivity2.class);
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

    private void initBinding() {
        marks = findViewById(R.id.marks);
        yourMarks = findViewById(R.id.yourMarks);
        percent = findViewById(R.id.percent);
        calculate = findViewById(R.id.calculate);
        backButton = findViewById(R.id.backButton);
    }

    private void calculate() {
        String Marks = marks.getText().toString();
        String yourMark = yourMarks.getText().toString();
        String yourPercent = percent.getText().toString();

        if (Marks.isEmpty()) {
            marks.setError("Enter Your Amount");
            return;
        } else if (yourMark.isEmpty()) {
            yourMarks.setError("Enter Your Interest");
            return;
        } else if (yourPercent.isEmpty()) {
            percent.setError("Enter Your Year");
            return;
        }
        double marks = Double.parseDouble(yourMark);
        double total = Double.parseDouble(Marks);

        double percentageValue = (marks / total) * 100;

        // Display the result with two decimal places
        percent.setText(String.format("%.2f%%", percentageValue));
    }
}