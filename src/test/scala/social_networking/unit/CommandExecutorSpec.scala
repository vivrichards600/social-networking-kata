package social_networking.unit

import social_networking.Spec.UnitSpec
import social_networking.{Application, Console, System, CommandExecutor}
import org.mockito.Mockito._
import org.mockito.BDDMockito._

class CommandExecutorSpec extends UnitSpec{
  "Command executor" should {
    "exit console" in {
      given(console.readline()) willReturn EXIT_COMMAND

      commandExecutor.execute(EXIT_COMMAND)

      verify(console).println("bye!")
      verify(system).exit
    }
  }

  val console = mock[Console]
  val system = mock[System]
  val commandExecutor = new CommandExecutor(console, system)
  val POST_COMMAND = "Alice -> It is a sunny day"
  val EXIT_COMMAND = "exit"
}
