package io.kata.sck

import org.junit.Test
import kotlin.test.assertEquals

class SckTest {
  @Test
  fun emptyStringToZero() {
    assertEquals("", 0.toString())
  }
}
