import kotlin.system.exitProcess

/**
 * Used for parsing provided arguments from CLI
 */
class ArgumentsParser(private val args: Array<String>) {

    private var printAll: Boolean = false
    private var printPrevious: Boolean = false
    private var printNext: Boolean = false
    private var isVerbose: Boolean = false
    private var noOptions: Boolean = false
    private var year: Int? = null

    fun execute() {
        if (args.isEmpty()) {
            printErrorMessage("Year is not specified!");
        }

        if (containsHelpOptions()) {
            printHelpMessageAndExit()
        }

        if (args.size == 1) {
            noOptions = true
            this.year = getYearOrError(args[0])
            return
        }

        for (arg in args) {
            when (arg) {
                "-a", "--all" -> {
                    printAll = true
                    isVerbose = true
                }
                "-n", "--next" -> printNext = true
                "-p", "--previous" -> printPrevious = true
                "-v", "--verbose" -> isVerbose = true
                else -> this.year = getYearOrError(arg)
            }
        }

        verifyAncestorsOptions()
    }

    fun shouldPrintAll(): Boolean = printAll
    fun shouldPrintNext(): Boolean = printNext
    fun shouldPrintPrevious(): Boolean = printPrevious
    fun isVerbose(): Boolean = isVerbose
    fun noOptionsSpecified(): Boolean = noOptions
    fun getYear(): Int? = year

    private fun getYearOrError(arg: String): Int? {
        if (arg == args.last() && args.last().toIntOrNull() != null) {
            return args.last().toInt()
        }
        printErrorMessage("Invalid argument '${arg}' !");
        return null;
    }

    private fun verifyAncestorsOptions() {
        if (!shouldPrintAll() && !isVerbose() && (shouldPrintNext() && shouldPrintPrevious())) {
            printErrorMessage("You can specify either '--next' parameter, or '--previous' when the '--verbose' is not required.")
        }
    }

    private fun getHelpMessage(): String {
        return """
        Usage: java -jar LeapYear.jar [OPTION]... YEAR
        
        Determine whether specified YEAR is a leap year.
        
        Possible OPTION(s):
            -a, --all           Print result message for specified year and also print previous and next leap year
            -h, --help          Print help message
            -n, --next          Return next leap year        
            -p, --previous      Return previous leap year
            -v, --verbose       Print result message
            
        Examples:
            java -jar LeapYear.jar -a 2025    Print the year '2025' is not a leap year and the previous leap year is 2024 and next '2028'
            java -jar LeapYear.jar 2000       return true
            java -jar LeapYear.jar -v 2000    Print message that the year '2000' is a leap year
            
        Compile files:
            kotlinc ArgumentsParser.kt LeapYearCalculator.kt LeapYearManager.kt LeapYearMain.kt -include-runtime -d LeapYear.jar
        """.trimIndent()
    }

    private fun printHelpMessageAndExit() {
        printMessageAndExit(getHelpMessage());
    }

    private fun printErrorMessage(message: String, errorCode: Int = -1) {
        println(message)
        println("")
        println(getHelpMessage())
        exitProcess(errorCode)
    }

    private fun printMessageAndExit(message: String, returnCode: Int = 0) {
        println(message)
        exitProcess(returnCode)
    }

    private fun containsHelpOptions(): Boolean {
        return args.contains("--help") || args.contains("-h")
    }

}