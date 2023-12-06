import dayOne.DayOne

fun main(args: Array<String>) {
    val dayOne = DayOne("src/main/kotlin/dayOne/input.txt")
    println("Part One Answer: ${dayOne.partOne()}")
    println("Part Two Answer: ${dayOne.partTwo()}")
}