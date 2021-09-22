package ru.tochka.test.task3

import scala.io.StdIn

/**
 * An app for validating email addresses.
 * The app doesn't cover:
 *  - quotations
 *  - comments e.g. john.smith(comment)@example.com
 *  - display names e.g. John Smith &lt;john.smith@example.org&gt;
 *
 * The email address specification is available here [[https://datatracker.ietf.org/doc/html/rfc3696#section-3]]
 */
object EmailValidator {

  private val localPartRegex = "[A-Za-z0-9!#$%&'*+\\-\\/=?^_`{|}~](\\.?[A-Za-z0-9!#$%&'*+\\-\\/=?^_`{|}~])*"
  private val dnsLabelRegex = "[A-Za-z0-9]([A-Za-z0-9]|-+[A-Za-z0-9])*"

  private val localPartMaxLength = 64
  private val domainMaxLength = 255
  private val dnsLabelMaxLength = 63

  def main(args: Array[String]): Unit = {
    val str = StdIn.readLine()
    if (isValidEmail(str)) {
      println(s"$str is a valid email")
    } else {
      println(s"$str is not a valid email")
    }
  }

  def isValidEmail(string: String): Boolean = {
    string.split('@') match {
      case Array(localPart, domain) =>
        val dnsLabels = domain.split('.')
        localPart.length <= localPartMaxLength && localPart.matches(localPartRegex) &&
          domain.length <= domainMaxLength && dnsLabels.last.exists(_.isLetter) && // Top level domain cannot be all-numeric
          dnsLabels.forall(label => label.length <= dnsLabelMaxLength && label.matches(dnsLabelRegex))
      case _ => false
    }
  }

}
