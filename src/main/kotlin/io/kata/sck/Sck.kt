package io.kata.sck

import java.lang.Integer.parseInt

class Sck {
  fun add(string: String): Int = when {
    string.isBlank() -> 0
    string.length == 1 -> parseInt(string)
    string.contains(",") -> string.split(",").stream()
      .flatMap { it.split("\n").stream() }
      .map { parseInt(it) }
      .reduce { v1, v2 -> v1 + v2}
      .get()
    else -> throw RuntimeException()
  }
}
