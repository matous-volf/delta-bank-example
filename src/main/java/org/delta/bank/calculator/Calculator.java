package org.delta.bank.calculator;

import java.util.stream.DoubleStream;

public class Calculator {
    public static double add(double... operands) {
        return DoubleStream.of(operands).sum();
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double... operands) {
        return DoubleStream.of(operands).reduce(1, (a, b) -> a * b);
    }

    public static double divide(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero.");
        }

        return a / b;
    }
}
