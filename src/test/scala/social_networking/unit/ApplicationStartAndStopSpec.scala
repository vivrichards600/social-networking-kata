package social_networking.unit

import scala.sys.process._
import social_networking.Spec.UnitSpec

class ApplicationStartAndStopSpec extends UnitSpec {

  "Litte Twitter" should {
    "should prompt > to Console when started and bye! for exit() userCommand" in {
      val output = twitterOutputForMessages("exit")
      output should equal( "> bye!\n")
    }
  }


  def twitterOutputForMessages(messages: String*): String = {
    (
      Seq("echo", messages.mkString("\r\n")) #|
      Seq("/usr/bin/scala", "-cp", "./target/scala-2.10/classes", "social_networking.Application")
    ).!!
  }


}