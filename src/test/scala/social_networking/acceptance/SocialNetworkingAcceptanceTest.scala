package social_networking.acceptance

import org.scalatest.Matchers
import scala.sys.process._

class SocialNetworkingAcceptanceTest extends  AcceptanceSpec with Matchers {

  feature ("Publishing and reading messages") {

    scenario("Alice publishes messages") {

      Given("Alice publishes messages")
      val conversation = List(
        "> " -> "Alice -> it's a nice day!",
        "> " -> "Alice -> very sunny!!",
        "> " -> "Alice read",

        "Alice - very sunny!!\n" + "Alice - it's a nice day!\n" + "> " -> "exit",

        "bye!\n" -> "")

      When("Bob views Alices messages")
      val output = twitterOutputForMessages(conversation.map(_._2))

      Then("The messages will be shown in Chronological order")
      output should be (messages(conversation.map(_._1)))
    }
  }

  def messages(messages: List[String]): String = {
    messages.mkString("")
  }

  def twitterOutputForMessages(messages: List[String]): String = {
    (
      Seq("echo",  messages.mkString("\r\n") + "\r\n") #|
        Seq("/usr/bin/scala", "-cp", "./target/scala-2.10/classes", "social_networking.Twitter")
      ).!!
  }



}
