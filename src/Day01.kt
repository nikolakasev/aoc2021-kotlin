import kotlin.collections.sumOf

fun main() {
    fun part1(input: List<String>): Int {
        // the depth measurement increases
        val transform: (List<Int>) -> Int = { if (it.last() > it.first()) 1 else 0}
        // turn from a list of strings to a list of integers
        val measurements = input.map { it.toInt() }

        // make pairs of measurements, count all the times a measurement increases
        return measurements.windowed(2, 1).sumOf(transform)
    }

    fun part2(input: List<String>): Int {
        val transform: (List<List<Int>>) -> Int = {if (it.first().sum() < it.last().sum()) 1 else 0}
        val measurements = input.map { it.toInt() }

        return measurements.windowed(3, 1).windowed(2, 1).sumOf(transform)
    }

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
