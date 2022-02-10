package org.mabartos.kotlin.basic

fun main() {

    val condition: Boolean = true

    val something: String = if (condition) "Yes" else "No"
    println("Is condition true? $something")

    println(getDayString(2))
    println(getDayString(5))
    println(isWeekendByDayNumber(2))
    println(isWeekendByDayNumber(6))
    println(isWeekendByDayNumber(7))
    println(isWeekendByDayNumber(42))

    val x = 2
    val y = 3

    val result = 1

    println(
        when (result) {
            (x + y) -> "add"
            (x * y) -> "mul"
            (y - x) -> "sub"
            else -> "unknown"
        }
    )

    val books = arrayOf("book1", "book2", "book3")

    for (i in books.indices) {
        println("Index $i")
    }

    for (i in 0 until books.size) {
        println(books[i])
    }

    for (book in books) {
        println("Book '$book'")
    }

    mainCycle@ for (i in 1..42424242) {
        innerCycle@ for (j in 0..999999999) {
            println("Number $i and $j")
            if (i * j > 333333) {
                break@mainCycle
            }
        }
    }




}

fun isWeekendByDayNumber(number: Number): Boolean {
    return when (number) {
        in 1..5 -> false
        6, 7 -> true
        else -> false;
    }
}

fun getDayString(number: Number): String {
    val dayString: String = when (number) {
        1 -> "Monday"
        2 -> "Tuesday"
        3 -> "Wednesday"
        else -> "Weekend is close"
    }

    return dayString
}