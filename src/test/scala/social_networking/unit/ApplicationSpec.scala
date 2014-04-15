package social_networking.unit

import social_networking.Spec.UnitSpec
import social_networking.{Application, Console, System, CommandExecutor}
import org.mockito.Mockito._
import org.mockito.BDDMockito._
import org.mockito.Matchers._

class ApplicationSpec extends UnitSpec{
  "Application" should {
    "handle a userCommand" in new context {
      given(console.readline()) willReturn(POST_COMMAND, EXIT_COMMAND)

      application.start()

      verify(commandExecutor).execute(POST_COMMAND)
    }
  }

  "Application" should {
    "print posts on the console when posts are returned" in new context {
      given(console.readline()) willReturn(READ_COMMAND, EXIT_COMMAND)
      given(commandExecutor.execute(READ_COMMAND)) willReturn(Some(List("It is a sunny day")))

      application.start()

      verify(console).println("It is a sunny day")
    }
  }

  trait context {
    val console = mock[Console]
    val system = mock[System]
    val commandExecutor = mock[CommandExecutor]
    given(commandExecutor.execute(anyString)) willReturn(None)
    val application = new Application(console, system, commandExecutor)
  }

  val POST_COMMAND = "Alice -> It is a sunny day"
  val EXIT_COMMAND = "exit"
  val READ_COMMAND = "Alice"
}
