package dayOne

import java.io.BufferedReader
import java.io.FileReader
import java.text.CharacterIterator
import java.text.StringCharacterIterator

class DayOne(private val filePath: String) {
    private val stringNumMap: Map<String, String> = mapOf("one" to "1",
        "two" to "2", "three" to "3", "four" to "4", "five" to "5",
        "six" to "6", "seven" to "7", "eight" to "8", "nine" to "9")
    private val keyList: List<String> = stringNumMap.keys.toList()
    fun partOne(): Int {
        val values: MutableList<Int> = arrayListOf()
        val reader = BufferedReader(FileReader(filePath))
        try {
            var line: String?

            while (reader.readLine().also { line = it } != null) {
                val tempString: String? = line?.filter(Char::isDigit)
                val stringVal: String = tempString?.first().toString().plus( tempString?.last())
                values.add(stringVal.toInt())
            }
        } catch (e: Exception) {
            println("An error occurred: ${e.message}")
        } finally {
            try {
                reader.close()
            } catch (e: Exception) {
                println("An error occurred while closing the file: ${e.message}")
            }
        }
        return values.sum()
    }

    fun partTwo(): Int {
        val values: MutableList<Int> = arrayListOf()
        val reader = BufferedReader(FileReader(filePath))
        try {
            var line: String?
            while (reader.readLine().also { line = it } != null) {
                val firstDigit: String? = line?.let { findLastDigit(it) }
                val lastDigit: String? = line?.let { findFirstDigit(it) }
                val stringVal: String = lastDigit.plus(firstDigit)
                values.add(stringVal.toInt())
            }
        } catch (e: Exception) {
            println("An error occurred: ${e.message}")
        } finally {
            try {
                reader.close()
            } catch (e: Exception) {
                println("An error occurred while closing the file: ${e.message}")
            }
        }
        return values.sum()
    }

    private fun findLastDigit(s: String): String {
        val it: CharacterIterator = StringCharacterIterator(s)
        var ch = it.last()
        val builder = StringBuilder()
        while (ch != CharacterIterator.DONE) {
            if(ch.isDigit())
                return ch.toString()
            builder.insert(0, ch)
            val foundKey = keyList.find { key -> builder.contains(key) }
            val value: String? = foundKey?.let { stringNumMap[it] }
            if(value != null)
                return value
            ch = it.previous()
        }
        return ""
    }

    private fun findFirstDigit(s: String): String {
        val it: CharacterIterator = StringCharacterIterator(s)
        var ch = it.first()
        val builder = StringBuilder()
        while (ch != CharacterIterator.DONE) {
            if(ch.isDigit())
                return ch.toString()
            builder.append(ch)
            val foundKey = keyList.find { key -> builder.contains(key) }
            val value: String? = foundKey?.let { stringNumMap[it] }
            if(value != null)
                return value
            ch = it.next()
        }
        return ""
    }

}