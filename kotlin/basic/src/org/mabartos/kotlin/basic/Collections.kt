package org.mabartos.kotlin.basic

fun main() {
    val numbers = listOf(1, 2, 3)
    println(numbers)

    val mutableNumbers: MutableList<Int> = mutableListOf(2, 3, 4)
    println(mutableNumbers)

    mutableNumbers.add(42)
    println(mutableNumbers)

    val arrayList = ArrayList<Int>()
    arrayList.add(1)
    arrayList.add(2)
    println(arrayList)

    val lotNumbers = listOf(0..1000)
    println("A lot of numbers chunked $lotNumbers")
    println(lotNumbers.chunked(5))

    val set = setOf(1, 2, 1, 2)
    println(set)

    val mutableSet = mutableSetOf(2, 3, 4, null, 5, 4)
    println(mutableSet)

    mutableSet.add(6)
    mutableSet.add(2)
    println(mutableSet)
    println(mutableSet.filterNotNull())
    val resultSet = mutableSet.filterNotNull().filter { it > 2 }
    println(resultSet)
    println(resultSet.groupBy { it % 5 })

    val map = hashMapOf("first" to "jedna", "second" to "dva")
    println(map)
    println(map.keys)
    println(map.values)

    val mutableMap = mutableMapOf(1 to 2, 2 to 3, 3 to 4)
    println(mutableMap)
    println(mutableMap.keys)
    println(mutableMap.values)
    mutableMap[4] = 5
    mutableMap.put(5, 6)
    println(mutableMap)
    println(mutableMap.keys)
    println(mutableMap.values)

    mutableMap.forEach { (k, v) -> println("$k and $v") }
    println("${mutableMap[1]}")
}