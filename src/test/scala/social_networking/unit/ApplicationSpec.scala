package social_networking.unit

import social_networking.Spec.UnitSpec
import social_networking.{Application, Console, System, CommandExecutor}
import org.mockito.Mockito._
import org.mockito.BDDMockito._

class ApplicationSpec extends UnitSpec{
  "Application" should {
    "handle a userCommand" in {
      given(console.readline()) willReturn(POST_COMMAND, EXIT_COMMAND)

      application.start()

      verify(commandExecutor).execute(POST_COMMAND)
    }
  }

  val console = mock[Console]
  val system = mock[System]
  val commandExecutor = mock[CommandExecutor]
  val application = new Application(console, system, commandExecutor)
  val POST_COMMAND = "Alice -> It is a sunny day"
  val EXIT_COMMAND = "exit"
}
