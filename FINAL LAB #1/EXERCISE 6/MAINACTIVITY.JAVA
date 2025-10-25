package com.example.finallab1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextDisplay;
    double num1 = 0, num2 = 0, result = 0;
    String operator = "";
    boolean isNew = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextDisplay = findViewById(R.id.editTextDisplay);

        int[] numberBtnIds = {
                R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
                R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9
        };

        for (int id : numberBtnIds) {
            Button btn = findViewById(id);
            btn.setOnClickListener(v -> addNumber(btn.getText().toString()));
        }


        findViewById(R.id.btnAdd).setOnClickListener(v -> setOperator("+"));
        findViewById(R.id.btnSubtract).setOnClickListener(v -> setOperator("-"));
        findViewById(R.id.btnMultiply).setOnClickListener(v -> setOperator("*"));
        findViewById(R.id.btnDivide).setOnClickListener(v -> setOperator("/"));


        findViewById(R.id.btc).setOnClickListener(v -> {
            editTextDisplay.setText("");
            operator = "";
            num1 = num2 = result = 0;
            isNew = true;
        });


        findViewById(R.id.btnDel).setOnClickListener(v -> {
            String current = editTextDisplay.getText().toString();
            if (!current.isEmpty()) {
                editTextDisplay.setText(current.substring(0, current.length() - 1));
            }
        });


        findViewById(R.id.btnResult).setOnClickListener(v -> calculateResult());
    }

    private void addNumber(String value) {
        if (isNew) {
            editTextDisplay.setText("");
            isNew = false;
        }
        editTextDisplay.append(value);
    }

    private void setOperator(String op) {
        String text = editTextDisplay.getText().toString();
        if (!text.isEmpty()) {
            num1 = Double.parseDouble(text);
            operator = op;
            editTextDisplay.append(" " + op + " ");
        }
    }

    private void calculateResult() {
        String text = editTextDisplay.getText().toString();


        if (text.equals("1234")) {
            editTextDisplay.setText("MISS YOU ❤️");
            isNew = true;
            return;
        }

        if (!text.contains(" ")) return;

        String[] parts = text.split(" ");
        if (parts.length < 3) return;

        num2 = Double.parseDouble(parts[2]);

        switch (operator) {
            case "+": result = num1 + num2; break;
            case "-": result = num1 - num2; break;
            case "*": result = num1 * num2; break;
            case "/":
                if (num2 == 0) {
                    Toast.makeText(this, "Cannot divide by 0", Toast.LENGTH_SHORT).show();
                    return;
                }
                result = num1 / num2;
                break;
        }

        editTextDisplay.setText(String.valueOf(result));
        isNew = true;
    }
}

