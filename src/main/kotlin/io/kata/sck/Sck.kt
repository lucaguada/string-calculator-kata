package io.kata.sck

import java.lang.Integer.parseInt

class Sck {
  fun add(string: String): Int =
    if (string.isBlank()) 0
    else if (string.length == 1) parseInt(string)
    else if (string.contains(",")) string.split(",").stream().map { parseInt(it) }.reduce { v1, v2 -> v1 + v2 }.get()
    else throw RuntimeException()
}
