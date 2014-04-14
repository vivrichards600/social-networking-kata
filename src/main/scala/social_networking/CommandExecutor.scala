package social_networking

class CommandExecutor(console: Console, system: System, commandFactory: CommandFactory) {
  def execute(userCommand: String) : Option[String] = {
    commandFactory create(userCommand) execute
  }
}
