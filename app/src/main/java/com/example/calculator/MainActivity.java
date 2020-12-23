package com.example.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText double_edit, double2_edit;
    private Button plus, minus, multiply, split;
    private TextView textView;
    private double a, b, res;

    private final static String RESULT_KEY = "RESULT_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        double_edit = findViewById(R.id.double_edit);
        double2_edit = findViewById(R.id.double2_edit);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        multiply = findViewById(R.id.multiply);
        split = findViewById(R.id.split);
        textView = findViewById(R.id.textView);


        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String edit1 = double_edit.getText().toString();
                String edit2 = double2_edit.getText().toString();
                a = Double.parseDouble(edit1);
                b = Double.parseDouble(edit2);
                res = a + b;
                textView.setText(String.valueOf(res));
                Toast.makeText(getApplicationContext(), "Успешная операция", Toast.LENGTH_LONG).show();
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String edit1 = double_edit.getText().toString();
                String edit2 = double2_edit.getText().toString();
                a = Double.parseDouble(edit1);
                b = Double.parseDouble(edit2);
                res = a - b;
                textView.setText(String.valueOf(res));
                Toast.makeText(getApplicationContext(), "Успешная операция", Toast.LENGTH_LONG).show();
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String edit1 = double_edit.getText().toString();
                String edit2 = double2_edit.getText().toString();
                a = Double.parseDouble(edit1);
                b = Double.parseDouble(edit2);
                res = a * b;
                textView.setText(String.valueOf(res));
                Toast.makeText(getApplicationContext(), "Успешная операция", Toast.LENGTH_LONG).show();

            }
        });

        split.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String edit1 = double_edit.getText().toString();
                String edit2 = double2_edit.getText().toString();
                a = Double.parseDouble(edit1);
                b = Double.parseDouble(edit2);
                if (edit2.equals("0"))
                    Toast.makeText(getApplicationContext(), "Знаменатель не может быть равен нулю", Toast.LENGTH_LONG).show();
                else {
                    res = a / b;
                    textView.setText(String.valueOf(res));
                    Toast.makeText(getApplicationContext(), "Успешная операция", Toast.LENGTH_LONG).show();

                }
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putDouble(RESULT_KEY, res);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        res = savedInstanceState.getDouble(RESULT_KEY, 0);
        textView.setText(String.valueOf(res));
    }

}