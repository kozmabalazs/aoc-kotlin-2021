fun main() {

    fun part1(inputs: List<String>): Int {
        var depth = 0
        var horizontalPosition = 0
        for (input in inputs) {
            val values = input.split(" ")
            val movement = values.firstOrNull()?.uppercase()?.let { value -> Movement.valueOf(value) } ?: continue
            val ammount = values.lastOrNull()?.toIntOrNull() ?: continue
            when(movement) {
                Movement.FORWARD -> horizontalPosition += ammount
                Movement.DOWN -> depth += ammount
                Movement.UP -> depth -= ammount
            }
            println("${movement.name} $ammount")
        }
        val multipliedValue = horizontalPosition * depth

        println("Final depth: $depth")
        println("Final horizontal position: $horizontalPosition")
        println("Multiply: $multipliedValue")

        return multipliedValue
    }

    fun part2(inputs: List<String>): Int {
        var depth = 0
        var horizontalPosition = 0
        var aim = 0
        for (input in inputs) {
            val values = input.split(" ")
            val movement = values.firstOrNull()?.uppercase()?.let { value -> Movement.valueOf(value) } ?: continue
            val ammount = values.lastOrNull()?.toIntOrNull() ?: continue
            when(movement) {
                Movement.FORWARD -> {
                    horizontalPosition += ammount
                    depth += (aim * ammount)
                }
                Movement.DOWN -> aim += ammount
                Movement.UP -> aim -= ammount
            }
            println("${movement.name} $ammount")

        }
        val multipliedValue = horizontalPosition * depth

        println("Final depth: $depth")
        println("Final horizontal position: $horizontalPosition")
        println("Multiply: $multipliedValue")

        return multipliedValue
    }

    val input = readInput("Day02")

    println(part1(input))
    println(part2(input))
}

enum class Movement {

    FORWARD,
    DOWN,
    UP

}