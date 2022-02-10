package org.mabartos.kotlin.basic

import java.util.function.Consumer
import java.util.function.Function

fun main(args: Array<String>) {
   /* stringDrill()
    arrayDrill()
    rangeDrill()
    unitFunction()
    calculateDrill()
    tryFunctions()*/
}

// Functions
fun tryFunctions() {
    myFirstInline { println("Ahooj") }

    tryConsumer("Ahoj", { f -> println(f) }, { f -> println("Second $f") })

    println(tryFunction(23) { f: Int -> "something $f" })
}

inline fun myFirstInline(function: () -> Unit) {
    println("Wrapper up")

    function()

    println("Wrapper down")
}

fun <T> tryConsumer(value: T, consumer: Consumer<T>, secondConsumer: Consumer<T>) {
    println("Consumer")
    consumer.accept(value)
    secondConsumer.accept(value)
}

fun <T, R> tryFunction(value: T, function: Function<T, R>): R {
    println("Try function")
    return function.apply(value)
}

/* Calculation */

fun calculateDrill() {
    println(calculate(1, 2, ::div))
    val result = calculate(1, 2, ::sum)
    println(result.toInt())

    println(calculate(1, 2, ::sub))
    //println(calculate(1, 2, ::operation))

    var someFunction = { f: String -> f.uppercase() }

    println(someFunction("asdf"))

    someFunction = { item: String -> item.lowercase() }

    println(someFunction("ASDF"))
}

fun div(a: Int, b: Int): Double {
    return a.toDouble().div(b.toDouble())
}

fun sum(a: Int, b: Int): Double {
    return (a + b).toDouble()
}

fun sub(a: Int, b: Int): Double = (a - b).toDouble()

fun calculate(a: Int, b: Int, operation: (Int, Int) -> Double): Double {
    return operation(a, b)
}

fun operation(): (Int, Int) -> Double {
    return ::sum
}

// Array Drill
fun arrayDrill() {
    val books = arrayOf("BOok1", "Book2")
    println(books.size)
    printArray(books)
    books[1] = "Book3"
    printArray(books)
    println(if ("BOok1" in books) "heeere" else "notHere");
    val nulls = arrayOfNulls<String>(2)
    println(nulls.size)
    printArray(nulls)
}

fun <T> printArray(array: Array<T>) {
    for (item in array) {
        println("Next is $item")
    }
}

// Range Drill
fun rangeDrill() {
    for (num in 1.rangeTo(4)) {
        println(num)
    }

    for (num in 1..10) {
        println("Another num $num")
    }

    for (num in 5 downTo 2) {
        println("Down $num")
    }

    for (num in 1..10 step 2) {
        println("I'm even odd $num number")
    }

    for (ch in 'a'..'f') {
        println(ch)
    }

    for (num in (1..5).reversed()) {
        println("I'm reversed $num")
    }

    for (num in 1 until 5) {
        println("We're numbers without the last one: $num")
    }

    println((0..255).first)
    println((0..255).last)
    println((0..255).endInclusive)
    println((0..255).step)
    println((0..10 step 3).step)

    val numbers = 1..10
    val filtered = numbers.filter { f -> f % 2 == 0 }

    println(numbers)
    println(filtered)
    printNumbersInfo(numbers)
}

fun printNumbersInfo(numbers: IntRange) {
    println(numbers)
    println(numbers.average())
    println(numbers.sum())
    println(numbers.count())
    println(numbers.count())
}

fun unitFunction(): Unit {
    println("I return Unit")
}

// String Drill
fun printMyName(name: String = "default", shouldBeUpperCase: Boolean = false): String {
    val finalName: String = when (name) {
        "default" -> "Default"
        else -> name
    }

    return if (shouldBeUpperCase) finalName.uppercase() else finalName
}

fun stringDrill() {
    var myVar: String = "MyVar"
    val myVal: String = "MyVal"

    println("Hello world!")
    println("What is my name? ${printMyName("ahoj")}")
    println("What is my name? ${printMyName()}")
    println("What is my name? ${printMyName(shouldBeUpperCase = true)}")
    println("What is my name? $myVar")
    println("What is my name? $myVal")

    myVar = "MyVar2"

    println("What is my name? $myVar")

    val condition = false

    println(condition && true)
    println(condition.and(true))

    val escapedString = "Escaped string\n"
    val rawString = """ 
        Hello
        How 
        Are
        You
    """

    println(escapedString)
    println(rawString)
    println(rawString.lastIndex)
    println(rawString.plus(escapedString))
    println(rawString + escapedString)
}
