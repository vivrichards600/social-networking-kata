package social_networking

class CommandExecutor(console: Console, system: System, commandFactory: CommandFactory) {
  def execute(userCommand: String) : Option[List[String]] = {
    commandFactory create(userCommand) execute
  }
}
