package social_networking

class Application(console: Console, system: System, commandExecutor: CommandExecutor) {

  def start() = {
    var userCommand = ""
    prompt
    while ({userCommand = console.readline(); userCommand != "exit"}) {
      val posts = commandExecutor.execute(userCommand): Option[List[String]]
      posts.getOrElse(List()).foreach(console println)
    }
    console print("bye!")
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