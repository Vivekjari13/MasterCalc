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

public class MainActivity5 extends AppCompatActivity {

    private EditText price, discount;
    private Button count;
    private ImageView back;
    private TextView discount1, saveAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main5);
        initBinding();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity5.this, MainActivity2.class);
                startActivity(intent);
            }
        });

        count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count();
            }
        });

    }

    private void initBinding(){
        price = findViewById(R.id.price);
        discount = findViewById(R.id.Discount);
        count = findViewById(R.id.count);
        back = findViewById(R.id.backButton);
        discount1 = findViewById(R.id.discount);
        saveAmount = findViewById(R.id.saved);
    }

    private void count(){
        String amount = price.getText().toString();
        String dis = discount.getText().toString();
        if (amount.isEmpty()) {
            price.setError("Enter Your Amount");
            return;
        } else if (dis.isEmpty()) {
            discount.setError("Enter discount");
            return;
        }
        double amount1 = Double.parseDouble(amount);
        double dis1 = Double.parseDouble(dis);

        double  a = ((amount1) * (dis1)) / 100;

        discount1.setText(String.valueOf((int)(amount1-a)));
        saveAmount.setText(String.valueOf((int) a));
    }
}