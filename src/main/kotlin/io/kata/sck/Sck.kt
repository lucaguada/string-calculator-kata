package io.kata.sck

import java.lang.Integer.parseInt

class Sck {
  fun add(string: String): Int = when {
    string.isBlank() -> 0

    string.startsWith("//") -> {
      val i = string.indexOf('\n')
      addBy(string.substring(2, i)
        .replace("[", "").replace("]", "")
        .let { string.substring(i + 1, string.length).split(it) })
    }

    string.length == 1 || string.contains(",") -> addBy(string.split(",").flatMap { it.split("\n") })

    else -> throw RuntimeException()
  }

  private fun addBy(numbers: List<String>): Int = numbers
    .map { parseInt(it) }
    .map {
      when {
        it < 0 -> throw RuntimeException("Negatives numbers not allowed: $it")
        else -> it
      }
    }
    .filter { it < 1000 }
    .reduce { v1, v2 -> v1 + v2 }
}
