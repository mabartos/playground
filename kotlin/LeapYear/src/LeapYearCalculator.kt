import kotlin.system.exitProcess

/**
 * Leap year calculator
 */
class LeapYearCalculator(private val year: Int) {

    companion object {
        const val STARTING_YEAR: Int = 1582

        fun isLeapYear(year: Int): Boolean {
            assertValidRange(year)

            if (year.mod(4) != 0) return false

            return year < STARTING_YEAR || year.mod(400) == 0 || year.mod(100) != 0
        }

        fun getPreviousLeapYear(year: Int): Int? {
            val result = findNearestLeapYear(year, Int::minus)
            if (result != null && result > year) errorOutOfRange()
            return result;
        }

        fun getNextLeapYear(year: Int): Int? {
            val result = findNearestLeapYear(year, Int::plus)
            if (result != null && result < year) errorOutOfRange()
            return result;
        }

        private fun findNearestLeapYear(year: Int, operation: (Int, Int) -> Int): Int? {
            return when (true) {
                isLeapYear(operation(year, 1)) -> operation(year, 1)
                isLeapYear(operation(year, 2)) -> operation(year, 2)
                isLeapYear(operation(year, 3)) -> operation(year, 3)
                isLeapYear(operation(year, 4)) -> operation(year, 4)
                else -> null
            }
        }

        fun isValidRange(year: Int): Boolean {
            return year >= Int.MIN_VALUE && year <= Int.MAX_VALUE;
        }

        private fun assertValidRange(year: Int) {
            if (!isValidRange(year)) {
                errorOutOfRange()
            }
        }

        private fun errorOutOfRange() {
            println("Provided year is out of range - You must accomplish Int boundaries (min = ${Int.MIN_VALUE}, max = ${Int.MAX_VALUE})");
            exitProcess(-1)
        }
    }

    fun isLeapYear() = isLeapYear(year)

    fun getPreviousLeapYear() = getPreviousLeapYear(year)

    fun getNextLeapYear() = getNextLeapYear(year)
}