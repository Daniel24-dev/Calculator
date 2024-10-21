package com.example.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Integer firstNumber, secondNumber;
    private Integer result;;

    private Boolean isOperationClick;
    private String currentOperation;
    private Button resultBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.main_textview);
        resultBtn = findViewById(R.id.result_btn);
        currentOperation = null;
        isOperationClick = false;

        resultBtn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, secondActivity.class);
            intent.putExtra("result", result.toString());
            startActivity(intent);
        });
    }

    public void onNumberClick(View view) {
        String text = ((MaterialButton) view).getText().toString();
        resultBtn.setVisibility(View.GONE);
        if (text.equals("AC")) {
            textView.setText("0");
        } else if (textView.getText().toString().equals("0") || isOperationClick) {
            textView.setText(text);
        } else {
            textView.append(text);
        }
        isOperationClick = false;
    }

    public void onOperationClick(View view) {
        if (view.getId() == R.id.btn_equal) {
            secondNumber = Integer.valueOf(textView.getText().toString());
            resultBtn.setVisibility(View.VISIBLE);

            if (currentOperation.equals("+")) {
                result = firstNumber + secondNumber;
            } else if (currentOperation.equals("-")) {
                result = firstNumber - secondNumber;
            } else if (currentOperation.equals("*")) {
                result = firstNumber * secondNumber;
            } else if (currentOperation.equals("/")) {
                if (secondNumber != 0) {
                    result = firstNumber / secondNumber;
                } else {
                    textView.setText("Ошибка");
                    return;
                }
            }

            textView.setText(result.toString());
        } else {
            firstNumber = Integer.valueOf(textView.getText().toString());

            if (view.getId() == R.id.btn_plus) {
                currentOperation = "+";
            } else if (view.getId() == R.id.btn_minus) {
                currentOperation = "-";
            } else if (view.getId() == R.id.btn_multiple) {
                currentOperation = "*";
            } else if (view.getId() == R.id.btn_divide) {
                currentOperation = "/";
            } else if (view.getId() == R.id.btn_percent) {
                currentOperation = "%";
            }

            isOperationClick = true;
        }
    }
}
