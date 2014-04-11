package social_networking.unit

import social_networking.Spec.UnitSpec
import social_networking.{CommandFactory, Console, System, CommandExecutor, Command}
import org.mockito.Mockito._
import org.mockito.BDDMockito._

class CommandExecutorSpec extends UnitSpec{
  "Command executor" should {
    "execute the userCommand issued by the user" in {
      given(commandFactory.create(POST_COMMAND)) willReturn command

      commandExecutor.execute(POST_COMMAND)

      verify(commandFactory).create(POST_COMMAND)
      verify(command).execute
    }
  }

  val console = mock[Console]
  val system = mock[System]
  val commandFactory = mock[CommandFactory]
  val command = mock[Command]
  val commandExecutor = new CommandExecutor(console, system, commandFactory)
  val POST_COMMAND = "Alice -> It is a sunny day"
  val EXIT_COMMAND = "exit"
}
