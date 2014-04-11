package social_networking

class CommandFactory(console:Console, system:System) {
  def create(command: String) : Command = {
    if (command contains "->") new PostCommand
    else new ExitCommand(console, system)
  }
}
