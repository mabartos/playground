import kotlin.system.exitProcess

/**
 * Main method for whole CLI application
 */
fun main(args: Array<String>) {
    LeapYearManager(args).execute()

    exitProcess(0)
}
