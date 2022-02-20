import kotlin.system.exitProcess

/**
 * Main function for tests
 */
fun main() {
    leapYears()
    nearestLeapYears()
    printAll()
}

fun leapYears() {
    assertLeapYear(0, true)
    assertLeapYear(1600, true)
    assertLeapYear(1700, false)
    assertLeapYear(1800, false)
    assertLeapYear(1900, false)
    assertLeapYear(2000, true)

    assertLeapYear(1976, true)
    assertLeapYear(1996, true)
    assertLeapYear(2004, true)

    assertLeapYear(2011, false)
    assertLeapYear(2013, false)
    assertLeapYear(2014, false)

    assertLeapYear(1300, true)
    assertLeapYear(1400, true)
    assertLeapYear(1492, true)
    assertLeapYear(1500, true)
    assertLeapYear(1580, true)
    assertLeapYear(LeapYearCalculator.STARTING_YEAR, false)
}

fun nearestLeapYears() {
    assertNearestLeapYears(2001, 2000, 2004)
    assertNearestLeapYears(1494, 1492, 1496)
    assertNearestLeapYears(1, 0, 4)
    assertNearestLeapYears(1580, 1576, 1584)
    assertNearestLeapYears(-1, -4, 0)

    // OUT of range
    // assertNearestLeapYears(Int.MIN_VALUE, -4, 0)
    // assertNearestLeapYears(Int.MAX_VALUE, -4, 0)
}

fun printAll() {
    //execute(arrayOf("--help"))
    execute(arrayOf("--all", "2000"))
    execute(arrayOf("-a", "2001"))

    execute(arrayOf("--verbose", "-n", "2000"))
    execute(arrayOf("--verbose", "-p", "1991"))
    execute(arrayOf("--verbose", "--next", "2000"))
    execute(arrayOf("--verbose", "--previous", "1991"))

    execute(arrayOf("--previous", "1991"))
    execute(arrayOf("--next", "1991"))
}

/* Utils */
fun execute(args: Array<String>) {
    println("---------Start---------")
    LeapYearManager(args).execute()
    println("---------End---------")
}

fun assertNearestLeapYears(year: Int, expectedPreviousLeapYear: Int, expectedNextLeapYear: Int) {
    val array = arrayOf(year.toString())
    val calculator = LeapYearManager(array).getCalculator()
    val prevLeapYear = calculator.getPreviousLeapYear()
    val nextLeapYear = calculator.getNextLeapYear()

    if (prevLeapYear != expectedPreviousLeapYear) {
        println("Test failed - Previous - $year (expected = ${expectedPreviousLeapYear}, actual = ${prevLeapYear})")
        exitProcess(-1)
    }

    if (nextLeapYear != expectedNextLeapYear) {
        println("Test failed - Next - $year (expected = ${expectedNextLeapYear}, actual = ${nextLeapYear})")
        exitProcess(-1)
    }

    println("Test passed - Previous/Next - $year")
}

fun assertLeapYear(year: Int, expectedStatus: Boolean) {
    val array = arrayOf(year.toString())
    val status = LeapYearManager(array).getCalculator().isLeapYear()

    if (status == expectedStatus) {
        println("Test passed - $year")
    } else {
        println("Test failed - $year (expected = ${expectedStatus}, actual = ${status})")
        exitProcess(-1)
    }
}