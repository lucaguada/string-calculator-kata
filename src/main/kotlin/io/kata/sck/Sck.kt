package io.kata.sck

import java.lang.Integer.parseInt
import java.util.Optional

class Sck {
  fun add(string: String): Int = when {
    string.isBlank() -> 0
    string.length == 1 -> parseInt(string)
    string.startsWith("//") -> Optional.of(string.substring(2, 3))
      .map { string.substring(4, string.length).split(it) }
      .get().stream()
      .map { parseInt(it) }
      .reduce { v1, v2 -> v1 + v2 }
      .get()
    string.contains(",") -> string.split(",").stream()
      .flatMap { it.split("\n").stream() }
      .map { parseInt(it) }
      .reduce { v1, v2 -> v1 + v2}
      .get()
    else -> throw RuntimeException()
  }
}
