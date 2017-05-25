package io.kata.sck

import java.lang.Integer.parseInt

class Sck {
  fun compute(string: String): Int =
    if (string.isBlank()) 0
    else if (string.length == 1) parseInt(string)
    else throw RuntimeException()
}
