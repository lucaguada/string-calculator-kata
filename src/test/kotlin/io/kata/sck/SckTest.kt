package io.kata.sck

import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class SckTest {
  private var sck:Sck? = null

  @Before
  fun before() { sck = Sck() }

  @Test
  fun emptyStringThenZero() {
    val computed = sck?.add("")
    assertEquals(0, computed)
  }

  @Test
  fun anyNumberStringThenIntegerNumber() {
    val computed = sck?.add("2")
    assertEquals(2, computed)
  }

  @Test
  fun anyNumberCommaThenSum() {
    val computed = sck?.add("3,4")
    assertEquals(7, computed)
  }

  @Test
  fun anyNumberCommaAndNewLineThenSum() {
    val computed = sck?.add("1\n2,3,1\n2")
    assertEquals(9, computed)
  }
}
