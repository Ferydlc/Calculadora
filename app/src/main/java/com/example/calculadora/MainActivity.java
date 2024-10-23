package com.example.calculadora;

import android.icu.util.IslamicCalendar;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView ResponseNum;
    private double num1 = 0, num2 = 0;
    private String operator = "";
    private boolean NewOperator = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ResponseNum = findViewById(R.id.ResponseNum);

        ButtonsConfig();
    }
    private void ButtonsConfig(){
        findViewById(R.id.buttonZero).setOnClickListener(v -> addNumber("0"));
        findViewById(R.id.buttonOne).setOnClickListener(v -> addNumber("1"));
        findViewById(R.id.buttonTwo).setOnClickListener(v -> addNumber("2"));
        findViewById(R.id.buttonThree).setOnClickListener(v -> addNumber("3"));
        findViewById(R.id.buttonFour).setOnClickListener(v -> addNumber("4"));
        findViewById(R.id.buttonFive).setOnClickListener(v -> addNumber("5"));
        findViewById(R.id.buttonSix).setOnClickListener(v -> addNumber("6"));
        findViewById(R.id.buttonSeven).setOnClickListener(v -> addNumber("7"));
        findViewById(R.id.buttonEight).setOnClickListener(v -> addNumber("8"));
        findViewById(R.id.buttonNine).setOnClickListener(v -> addNumber("9"));
        findViewById(R.id.buttonDecimal).setOnClickListener(v -> addNumber("."));
        //operadores
        findViewById(R.id.buttonAddition).setOnClickListener(v -> addOperator("+"));
        findViewById(R.id.buttonSubtraction).setOnClickListener(v -> addOperator("-"));
        findViewById(R.id.buttonMultiply).setOnClickListener(v -> addOperator("×"));
        findViewById(R.id.buttonSplit).setOnClickListener(v -> addOperator("÷"));
        findViewById(R.id.buttonEqual).setOnClickListener(v -> DoOperation());
        findViewById(R.id.buttonAC).setOnClickListener(v -> Clear());

    }
    private  void addNumber(String number) {
        if (NewOperator){
            ResponseNum.setText(number);
            NewOperator = false;
        }else {
            ResponseNum.append(number);
        }
    }
    private void  addOperator(String operator){
        num1 = Double.parseDouble(ResponseNum.getText().toString());
        this.operator = operator;
        NewOperator = true;
    }

    private  void DoOperation(){
        num2 = Double.parseDouble(ResponseNum.getText().toString());
        CalculadoraActivity operation = null;

        switch (operator){
            case "+":
                operation = new Addition();
                break;
            case "-":
                operation = new Subtraccion();
                break;
            case "×":
                operation = new Multiply();
                break;
            case "÷":
                operation = new Split();
                break;
        }
        if(operator != null){
            double response = operation.calculate(num1,num2);
            ResponseNum.setText(String.valueOf(response));
        }
    }

    private void  Clear(){
        num1 = 0;
        num2 = 0;
        operator = "";
        ResponseNum.setText("0");
        NewOperator = true;
    }
}