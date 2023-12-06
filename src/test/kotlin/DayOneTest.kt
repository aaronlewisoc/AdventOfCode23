import dayOne.DayOne
import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.test.Test

class DayOneTest {

    @Test
    fun testPartOne() {
        val dayOne = DayOne("src/main/kotlin/dayOne/testInput.txt")
        assertEquals(dayOne.partOne(), 142)
    }

    @Test
    fun testPartTwo() {
        val dayOne = DayOne("src/main/kotlin/dayOne/testInputTwo.txt")
        assertEquals(dayOne.partTwo(), 281)
    }
}