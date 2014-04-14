package social_networking

class ExitCommand (console: Console, system:System) extends Command {
  override def execute(): Option[List[String]] = {
    console println "bye!"
    system.exit
    None
  }
}
