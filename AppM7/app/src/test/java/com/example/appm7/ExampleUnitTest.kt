package com.example.appm7

import org.junit.Assert
import org.junit.Test

// Clase CalculatorTest.java


class CalculatorTest {
    @Test
    fun testAdd() {
        val calculator = Calculator()
        val result: Int = calculator.add(3, 4)
        Assert.assertEquals(7, result.toLong())
    }

    @Test
    fun testSubtract() {
        val calculator = Calculator()
        val result: Int = calculator.subtract(7, 4)
        Assert.assertEquals(3, result.toLong())
    }

    @Test
    fun testMultiply() {
        val calculator = Calculator()
        val result: Int = calculator.multiply(3, 4)
        Assert.assertEquals(12, result.toLong())
    }

    @Test
    fun testDivide() {
        val calculator = Calculator()
        val result: Int = calculator.divide(8, 4)
        Assert.assertEquals(2, result.toLong())
    }

    @Test(expected = IllegalArgumentException::class)
    fun testDivideByZero() {
        val calculator = Calculator()
        calculator.divide(8, 0)
    }
}

