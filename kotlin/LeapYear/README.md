# Leap Year Calculator

### Martin Bartos - xbartos5

This CLI application, written in Kotlin, determines whether the provided year is Leap year, or not. If you don't have
compiler for Kotlin, you can directly execute the JAR file (`LeapYear.jar`).

#### Without `kotlinc` compiler:

```shell
java -jar src/LeapYear.jar --help
```

#### With `kotlinc` compiler:

```shell
cd src
kotlinc ArgumentsParser.kt LeapYearCalculator.kt LeapYearManager.kt LeapYearMain.kt -include-runtime -d LeapYear.jar`
java -jar LeapYear.jar --help
```

### Execute the program

First of all, you can execute the JAR file with option `--help`, where you can find all necessary information. In order
to execute the program in _basic_ mode, you can execute this command:

```shell
java -jar LeapYear.jar 2020
```

### After executing `--help` command

Usage: java -jar LeapYear.jar [OPTION]... YEAR

```shell
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
```

### Tests

Tests are included in the `testSrc` folder.
