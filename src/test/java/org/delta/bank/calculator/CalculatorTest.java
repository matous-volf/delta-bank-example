package org.delta.bank.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

public class CalculatorTest {
    @Test
    @DisplayName("add two numbers")
    void add() {
        assertEquals(4, Calculator.add(2, 2));
        assertEquals(2, Calculator.add(-2, 4));
    }

    @Test
    @DisplayName("subtract two numbers")
    void subtract() {
        assertEquals(2, Calculator.subtract(4, 2));
        assertEquals(-6, Calculator.subtract(-2, 4));
    }

    @Test
    @DisplayName("multiply two numbers")
    void multiply() {
        assertEquals(6, Calculator.multiply(2, 3));
        assertEquals(-8, Calculator.multiply(-2, 4));
    }

    @Test
    @DisplayName("divide two numbers")
    void divide() {
        assertEquals(4, Calculator.divide(8, 2));
        assertEquals(-3, Calculator.divide(9, -3));
        assertThrowsExactly(IllegalArgumentException.class, () -> Calculator.divide(2, 0));
    }
}
