package social_networking

class ExitCommand (console: Console, system:System) extends Command {
  override def execute(): Option[String] = {
    console println "bye!"
    system.exit
    None
  }
}
