package com.example.cleanjsonholder

import com.example.cleanjsonholder.util.FizzBuzzCalculate
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    private val fizzBuzzCalculate = FizzBuzzCalculate()

    @Test
    fun `calculate return string 1`() {
        val d = fizzBuzzCalculate.calculate(1)
        assertEquals("1", d)
    }

    @Test
    fun `calculate return string 2`() {
        val d = fizzBuzzCalculate.calculate(2)
        assertEquals("2", d)
    }

    @Test
    fun `calculate return string 3`() {
        val d = fizzBuzzCalculate.calculate(3)
        assertEquals("Fizz", d)
    }

    @Test
    fun `calculate return string 4`() {
        val d = fizzBuzzCalculate.calculate(4)
        assertEquals("4", d)
    }

    @Test
    fun `calculate return string 5`() {
        val d = fizzBuzzCalculate.calculate(5)
        assertEquals("Buzz", d)
    }

    @Test
    fun `calculate return string 8 return God`() {
        val d = fizzBuzzCalculate.calculate(8)
        assertEquals("God", d)
    }

    @Test
    fun `calculate return string 15`() {
        val d = fizzBuzzCalculate.calculate(15)
        assertEquals("FizzBuzz", d)
    }

}