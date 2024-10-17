package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Integer firstNumber, secondNumber, result;
    private Boolean isOperationClick;
    private String currentOperation ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
       setContentView(R.layout.activity_main);
        // ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
       //     Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
         //   v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
        //    return insets;
       // });
        textView= findViewById(R.id.main_textview);
        currentOperation = null;
    }

  public void onNumberClick(View view) {
      String text = ((MaterialButton) view).getText().toString();
      if (text.equals("AC")){
          textView.setText("0");
      }else if(textView.getText().toString().equals("0") || isOperationClick){
        textView.setText(text);
      }else {
          textView.append(text);
      }
      isOperationClick = false;
    }

    public void onOperationClick(View view) {

        if (view.getId() == R.id.btn_plus){
            firstNumber = Integer.valueOf(textView.getText().toString());
            currentOperation = "+";
        } else if (view.getId() == R.id.btn_minus) {
            firstNumber = Integer.valueOf(textView.getText().toString());
            currentOperation = "-";

        } else if (view.getId() == R.id.btn_multiple) {
            firstNumber = Integer.valueOf(textView.getText().toString());
            currentOperation = "*";

        }else if (view.getId() == R.id.btn_divide) {
            firstNumber = Integer.valueOf(textView.getText().toString());
            currentOperation = "/";

        }else if (view.getId() == R.id.btn_percent){
            firstNumber = Integer.valueOf(textView.getText().toString());
            currentOperation = "%";
        }
        else if (view.getId()==R.id.dot){
            firstNumber = Integer.valueOf(textView.getText().toString()+ ".");
        }
        else if (view.getId() == R.id.btn_equal) {
            secondNumber = Integer.valueOf(textView.getText().toString());
            if (currentOperation.equals("+")){
                Integer result = firstNumber + secondNumber;
                textView.setText(result.toString());
            } else if (currentOperation.equals("-")) {
                Integer result = firstNumber - secondNumber;
                textView.setText(result.toString());
            }else if (currentOperation.equals("*")) {
                Integer result = firstNumber * secondNumber;
                textView.setText(result.toString());
            }else if (currentOperation.equals("/")) {
                Integer result = firstNumber / secondNumber;
                textView.setText(result.toString());
            }


        }
        isOperationClick = true;

    }

}
