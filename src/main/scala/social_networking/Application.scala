package social_networking

class Application(console: Console, system: System, commandExecutor: CommandExecutor) {

  def start() = {
    var userCommand = ""
    prompt
    while (userCommand != "exit") {
      userCommand = console.readline()
      commandExecutor.execute(userCommand)
    }
  }

  private def prompt {
    console print("> ")
  }
}

object Application extends App {

  val console = new Console
  val system = new System
  val userRepository = new UserRepository
  val commandFactory = new CommandFactory(console: Console, system: System, userRepository: UserRepository)
  val commandExecutor = new CommandExecutor(console: Console, system: System, commandFactory:CommandFactory)
  val twitter = new Application(console, system, commandExecutor)

  twitter start
}