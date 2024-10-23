package com.example.calculadora;

public class Split extends CalculadoraActivity{
    @Override
    public double calculate(double num1, double num2){
        if (num2 != 0){
            return num1/num2;
        }else {
            throw  new ArithmeticException("SYNTAX ERROR");
        }
    }
}
