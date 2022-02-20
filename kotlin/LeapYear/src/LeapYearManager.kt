import kotlin.system.exitProcess

/**
 * Leap Year Manager, which handles whole process of executing the CLI program
 */
class LeapYearManager(args: Array<String>) {

    private var year: Int = 0
    private var calculator: LeapYearCalculator
    private val parser: ArgumentsParser = ArgumentsParser(args)

    init {
        parser.execute()
        this.year = validateAndGetYear()
        this.calculator = LeapYearCalculator(year)
    }

    fun execute() {
        when (true) {
            parser.noOptionsSpecified() -> {
                printLeapYear()
            }
            parser.shouldPrintAll() -> {
                printLeapYear()
                printPreviousLeapYear()
                printNextLeapYear()
            }
            parser.shouldPrintPrevious() -> printPreviousLeapYear()
            parser.shouldPrintNext() -> printNextLeapYear()
            else -> printLeapYear()
        }
    }

    fun getCalculator(): LeapYearCalculator = calculator

    private fun printLeapYear() {
        if (parser.isVerbose()) {
            println("Is the '${year}' a leap year? ${if (calculator.isLeapYear()) "Yes" else "No"}")
        } else {
            println(calculator.isLeapYear())
        }
    }

    private fun printPreviousLeapYear() {
        if (parser.isVerbose()) {
            println("The previous leap year before '${year}' is '${calculator.getPreviousLeapYear()}'")
        } else {
            println(calculator.getPreviousLeapYear())
        }
    }

    private fun printNextLeapYear() {
        if (parser.isVerbose()) {
            println("The next leap year after '${year}' is '${calculator.getNextLeapYear()}'")
        } else {
            println(calculator.getNextLeapYear())
        }
    }

    private fun validateAndGetYear(): Int {
        val year: Int? = parser.getYear()

        if (year == null) {
            println("Please specify valid year.");
            exitProcess(-1);
        }

        return year;
    }

}