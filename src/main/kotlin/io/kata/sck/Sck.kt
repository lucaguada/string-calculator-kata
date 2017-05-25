package io.kata.sck

class Sck {
  fun compute(string:String):Int = when (string) {
    "" -> 0
    "1" -> 1
    else -> throw RuntimeException()
  }
}
