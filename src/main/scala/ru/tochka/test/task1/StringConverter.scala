package ru.tochka.test.task1

/*
 * Задание 1.
 * Есть строка, нужно используя методы коллекций скалы,
 *  сгруппировать буквы по символу,
 *  отсортировать группы по количеству символов и сджойнить группы в одну строку.
 *  Пример: “abcaba” -> “aaabbc” или “aacbc” -> “aaccb”
 *
 * Группы с одинаковым кол-вом символов могут быть в произвольном порядке, например “qwe” или “eqw”
 */

object StringConverter {

  implicit class Implicits(string: String) {
    def convert: String = {
      string.groupBy(identity).values.toSeq
        .sortBy(s => (s.length, s.head))(Ordering.Tuple2(Ordering.Int.reverse, Ordering.Char))
        .mkString
    }
  }

}