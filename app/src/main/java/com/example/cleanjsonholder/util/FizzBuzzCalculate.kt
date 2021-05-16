package com.example.cleanjsonholder.util

class FizzBuzzCalculate {

    private val listFizzBuzz = listOf("FizzBuzz", "Fizz", "Buzz", "God")
    private val listCondition = listOf(15, 3, 5, 8)

    fun calculate(number: Int): String {

        listCondition.forEachIndexed { index, value ->
            if (number % value == 0) {
                return listFizzBuzz[index]
            }
        }

        return number.toString()
    }
}