package ru.tochka.test.task1

import ru.tochka.test.task1.StringConverter.Implicits

object StringConverterTest extends App {
  val t = "asdasdaaaweqbbbbasdasd".convert
  val expected = "aaaaaaabbbbddddsssseqw"
  assert(t == expected, s"$t is not equal to $expected")

  val t2 = "".convert
  assert(t2 == "", s"$t2 is not equal to \"\"")
}