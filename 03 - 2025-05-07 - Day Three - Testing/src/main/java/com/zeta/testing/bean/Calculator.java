package com.zeta.testing.bean;

public class Calculator {
    public double calculate(double firstOperand, double secondOperand, char operator) {
        return switch (operator) {
            case '+' -> add(firstOperand, secondOperand);
            case '-' -> subtract(firstOperand, secondOperand);
            case '*' -> multiply(firstOperand, secondOperand);
            case '/' -> divide(firstOperand,secondOperand);
            default -> throw new ArithmeticException("Invalid operator: " + operator);
        };
    }

    private double divide(double firstOperand, double secondOperand) {
        return firstOperand / secondOperand;
    }

    private double multiply(double firstOperand, double secondOperand) {
        return firstOperand * secondOperand;
    }

    private double subtract(double firstOperand, double secondOperand) {
        return firstOperand - secondOperand;
    }

    private double add(double firstOperand, double secondOperand) {
        return firstOperand + secondOperand;
    }
}