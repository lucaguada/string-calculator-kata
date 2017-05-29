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

  @Test(expected = RuntimeException::class)
  fun anyNumberStringThenIntegerNumber() {
    val positive = sck?.add("2")
    assertEquals(2, positive)

    sck?.add("-2")
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

  @Test
  fun anyNumberCustomDelimiterThenSum() {
    val computed = sck?.add("//;\n1;2")
    assertEquals(3, computed)
  }

  @Test(expected = RuntimeException::class)
  fun negativeNumbersThenException() {
    sck?.add("1,4,-1")
  }

  @Test
  fun ignoreBiggerNumbersThan1000() {
    val computed = sck?.add("1,4,1000")
    assertEquals(5, computed)
  }

  @Test
  fun anyDelimiterLimit() {
    val computed = sck?.add("//[***]\n2***2***2")
    assertEquals(6, computed)
  }
}
