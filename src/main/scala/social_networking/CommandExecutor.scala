package social_networking

class CommandExecutor(console: Console, system: System) {
  def execute(command: String) {
    if (command == "exit") {
      console println "bye!"
      system.exit
    } else prompt
  }

  private def prompt {
    console print("> ")
  }
}
