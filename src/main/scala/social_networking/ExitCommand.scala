package social_networking

class ExitCommand (console: Console, system:System) extends Command {
  override def execute(): Unit = {
    console println "bye!"
    system.exit
  }
}
