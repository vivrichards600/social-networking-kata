package social_networking.unit

import social_networking.Spec.UnitSpec
import social_networking._

class CommandFactorySpec extends UnitSpec{
   "Command factory" should {
     "create an exit command" in {
       val command = commandFactory.create(EXIT_USER_COMMAND)

       command shouldBe an [ExitCommand]
     }
   }

  "Command factory" should {
    "create a post command" in {
      val command = commandFactory.create(POST_USER_COMMAND)

      command shouldBe a [PostCommand]
    }
  }

  val console = new Console
  val system = new System
  val userRepository = mock[UserRepository]
  val commandFactory = new CommandFactory(console: Console, system: System, userRepository: UserRepository)
  val EXIT_USER_COMMAND = "exit"
  val POST_USER_COMMAND = "Alice -> It is a sunny day"
}