package ru.tochka.test.task3

object EmailValidatorTest {

  def main(args: Array[String]): Unit = {
    val validEmails = Seq(
      "simple@example.com",
      "simple@123.com",
      "very.common@example.com",
      "disposable.style.email.with+symbol@example.com",
      "other.email-with-hyphen@example.com",
      "fully--qualified-domain@example.com",
      "user.name+tag+sorting@example.com",
      "x@example.com",
      "example-indeed@strange-example.com",
      "test/test@test.com",
      "admin@mailserver1",
      "example@s.example",
      "mailhost!username@example.org",
      "user%example.com@example.org",
      "user-@example.org"
    )
    validEmails.foreach { email =>
      assert(EmailValidator.isValidEmail(email), s"isValidEmail($email) was false")
    }

    val invalidEmails = Seq(
      "simple@-example.com",
      "simple@example-.com",
      "simple@example.123",
      "Abc.example.com",
      "A@b@c@example.com",
      "1234567890123456789012345678901234567890123456789012345678901234+x@example.com",
      "i_like_underscore@but_its_not_allowed_in_this_part.example.com",
      "John..Doe@example.com",
      "John.@example.com",
      ".Doe@example.com",
      "@",
      ""
    )
    invalidEmails.foreach { email =>
      assert(!EmailValidator.isValidEmail(email), s"isValidEmail($email) was true")
    }
  }

}
