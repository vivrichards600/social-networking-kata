package social_networking.unit

import social_networking.Spec.UnitSpec
import social_networking.ExitCommand
import social_networking.{Console, System}
import org.mockito.Mockito._

class ExitCommandSpec extends UnitSpec{
  "Exit command" should {
    "print 'bye!' to the console and exit the application" in {
        val exitCommand = new ExitCommand(console, system)

        exitCommand.execute()

        verify(console).println("bye!")
        verify(system).exit
    }
  }

  val console = mock[Console]
  val system = mock[System]
}
