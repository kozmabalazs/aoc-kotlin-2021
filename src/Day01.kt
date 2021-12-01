fun main() {

    fun part1(input: List<Int>): Int {
        var timesIncreased = 0
        var previousNum: Int? = null
        for (value in input) {
            when {
                previousNum == null -> println("$value (N/A - no previous measurement)")
                previousNum < value -> {
                    println("$value (increased)")
                    timesIncreased++
                }
                previousNum > value -> println("$value (decreased)")
                previousNum == value -> println("$value (no change)")
            }
            previousNum = value
        }
        return timesIncreased
    }

    fun part2(input: List<Int>): Int {
        var timesIncreased = 0
        var previousSum: Int? = null
        for ((index, value) in input.withIndex()) {
            val value1 = value
            val value2 = input.getOrNull(index + 1) ?: continue
            val value3 = input.getOrNull(index + 2) ?: continue
            val sumOfValues = value1 + value2 + value3
            when {
                previousSum == null -> println("$sumOfValues (N/A - no previous sum)")
                previousSum < sumOfValues -> {
                    println("$sumOfValues (increased)")
                    timesIncreased++
                }
                previousSum > sumOfValues -> println("$sumOfValues (decreased)")
                previousSum == sumOfValues -> println("$sumOfValues (no change)")
            }
            previousSum = sumOfValues
        }
        return timesIncreased
    }

    val input = readInput("Day01")
        .mapNotNull { value -> value.toIntOrNull() }

    println(part1(input))
    println(part2(input))
}
