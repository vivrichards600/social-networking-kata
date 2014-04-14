package social_networking

class ReadCommand(command: String, userRepository: UserRepository) extends Command {
  override def execute: Unit = {
    userRepository.postsBy(command)
  }
}
