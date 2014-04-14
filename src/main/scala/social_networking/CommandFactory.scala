package social_networking

class CommandFactory(console:Console, system:System, userRepository: UserRepository) {
  def create(command: String) : Command = {
    if (command contains "->") new PostCommand(command, userRepository)
    else new ExitCommand(console, system)
  }
}
