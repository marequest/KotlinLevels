package org.example

import kotlin.math.sign

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val myTests = myTests()
    myTests.doShapes()
}


class myTests() {

    //region BEGGINER LEVEL
    fun sum(a: Int, b: Int): Int {
        return a + b
    }

    fun capitalizeSentence(str: String): String {
        return str.split(" ").joinToString(" ") { it.capitalize() }
    }

    fun countDown(n: Int): List<Int> {
        return (n downTo 0 ).toList()
    }

    fun getOddNumbers(list: List<Int>): List<Int> {
        return list.filter { it % 2 != 0}
    }
    val getOddNumbers1: (List<Int>) -> List<Int> = { it.filter{ it % 2 != 0 } }

    fun containsRange(range1: IntRange, range2: IntRange): Boolean {
        return range1.contains(range2.first) && range1.contains(range2.last)
    }

    fun linearSearch(list: List<String>, target: String): Int {
        for (i in list.indices) {
            if (list[i] == target) {
                return i
            }
        }
        return -1
    }

    fun formatTrainRoute(route: List<String>): String {
        var result = "Train is calling at"
        if (route.size == 1){
            return result + " " + route[0]
        } else {
            for (station in route.dropLast(1)) {
                result += " $station,"
            }
            result = result.removeSuffix(",") + " and ${route.last()}"
            return result
        }
    }
    fun formatTrainRoute1(route: List<String>): String {
        return "Train is calling at " + route.dropLast(1).joinToString(", ") + " and ${route.last()}"
    }
    //endregion

    //region INTERMEDIATE LEVEL

//    fun isAnagram(str1:String, str2:String) : Boolean {
//        return str1.toCharArray().sorted() == str2.toCharArray().sorted()
//    }
    fun isAnagram(str1:String, str2:String) : Boolean {
        val map1 = str1.lowercase()
            .filter { it.isLetterOrDigit() }
            .groupingBy { it }
            .eachCount()
        val map2 = str2.lowercase()
            .filter { it.isLetterOrDigit() }
            .groupingBy { it }
            .eachCount()
        return map1 == map2
    }

    fun isPermutationPalindrome(str: String): Boolean {
        val map = str.lowercase()
            .filter { it.isLetterOrDigit() }
            .groupingBy { it }
            .eachCount()
        return map.values.count { it % 2 != 0 } <= 1
    }

    fun maxOccurringChar(str: String): String {
        return str.lowercase()
            .filter { it.isLetterOrDigit() }
            .groupingBy { it }
            .eachCount()
            .maxByOrNull { it.value }!!.key.toString()
    }

    fun reverseString(str: String): String {
        return str.foldRight("") { char, acc -> acc + char}
    }

    fun countTheVowels(str: String): Int {
        val vowels = setOf('a', 'e', 'o', 'u', 'i')
        return str.count { it in vowels }
    }

    fun reverseInt(number: Int): Int {
        return number.toString().removePrefix("-").reversed().toInt() * number.sign
    }

    val stepsGenerator: (n: Int) -> List<String> = { n ->
        (1..n).map{
            "#".repeat(it) + " ".repeat(n-it)
        }
    }

    fun fizzBuzz(n: Int): List<String> {
        return (1..n).map {
            when {
                it % 3 == 0 && it % 5 == 0 -> "FizzBuzz"
                it % 3 == 0 -> "Fizz"
                it % 5 == 0 -> "Buzz"
                else -> it.toString()
            }
        }
    }

    fun caesarCipher(str: String, n: Int) = str.map {
        when {
            it.isLetter() -> {
                val base = if (it.isLowerCase()) 'a' else 'A'
                base + (it - base + n) % 26
            }
            else -> it
        }
    }.joinToString("")

    fun doesCharAppearMoreThanOnce(str: String) : Boolean = str.groupingBy { it }.eachCount().values.any { it > 1 }

    fun returnSmallestNElements(elements: List<Int>, n: Int): List<Int> {
        return elements.sorted().take(n)
    }
    //endregion

    //region ADVANCED LEVEL
    class Stack<T> {
        private val elements = mutableListOf<T>()

        val size get() = elements.size

        fun add(element: T) {
            elements.add(element)
        }

        fun add(): (T) -> Unit = { elements.add(it) }

        fun remove() = elements.removeLastOrNull()

        fun peek() = elements.lastOrNull()

        fun isEmpty(): Boolean {
            return elements.isEmpty()
        }
    }

    fun weave(stack1: myTests.Stack<*>, stack2: myTests.Stack<*>): myTests.Stack<*> {
        val newStack = myTests.Stack<Any>()
        while (true) {
            stack1.remove()?.let { newStack.add(it) }
            stack2.remove()?.let { newStack.add(it) }
            if (stack1.peek() == null || stack2.peek() == null) {
                break
            }
        }
        return newStack
    }

    fun digitFrequency(str1: String, str2: String): Boolean {
        return str1.groupingBy { it }.eachCount() == str2.groupingBy { it }.eachCount()
    }

//    fun getDuplicatedArguments(list: List<String>): List<String> {
//        return list
//            .groupingBy { it }
//            .eachCount()
//            .filter { it.value > 1 }
//            .keys
//            .toList()
//    }
    fun getDuplicatedArguments(list: List<String>): List<String> {
        return list
            .groupingBy { it }
            .eachCount()
            .filter { it.value > 1 }
            .flatMap { (item, count) -> List(count) {item} }
    }

    fun listHasTwoElementsWhichAverageIsEqualToTarget(list: List<Int>, target: Double): Boolean {
        return list.flatMap { i -> list.map { j -> (i + j) / 2.0 } }.contains(target)
    }
    fun elementsWhichAverageIsEqualToTarget(list: List<Int>, target: Double): List<Pair<Int, Int>> {
        return list.flatMap { i ->
            list.mapNotNull { j ->
                if ((i + j) / 2.0 == target && i < j) Pair(i, j)
                else null
            }
        }
    }
    fun hasAverageOptimal(list: List<Int>, target: Double): Boolean {
        if (list.size < 2) return false
        var left = 0
        var right = list.lastIndex
        while (left != right) {
            val average = (list[left] + list[right]) / 2.0
            when {
                average == target -> return true
                average > target -> right--
                else -> left++
            }
        }
        return false;
    }

    fun anyCallbak(list: List<Int>, callback: (Int) -> Boolean): Boolean {
        if (list.size == 1)
            return callback(list.first())
        return callback(list.first()) || anyCallbak(list.drop(1), callback)
    }

    fun flatten(list: List<Any>): List<Any> {
        return list.flatMap {
            if (it is List<*>) flatten(it.filterNotNull()) else listOf(it)
        }
    }

    fun surroundedLetter(str: String): Boolean {
        str.forEachIndexed { idx, char ->
            if (char.isLetter()) {
                if (idx == 0 || idx == str.lastIndex || str[idx - 1] != '+' || str[idx + 1] != '+')
                    return false
            }
        }
        return true
    }

    fun binarySearch(list: List<Int>, target: Int): Int = TODO("Not implemented")
    //endregion

    //region RANDOM

    fun zipTwoLists(list1: List<Int>, list2: List<Int>): List<Int> {
        return list1.zip(list2).flatMap {
            listOf(it.first, it.second)
        }
    }

    open class Shape(val name: String)

    class Circle(circleName: String) : Shape(circleName)

    fun printShapes(shapes: List<Shape>) {
        shapes.forEach {
            println(it.name)
        }
    }

    fun doShapes(){
        val list: List<Circle> = listOf(Circle("Circle1"), Circle("Circle2"))
        printShapes(list)
    }


}












