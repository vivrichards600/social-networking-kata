package social_networking

class ReadCommand(user: String, userRepository: UserRepository) extends Command {
  override def execute: Unit = {
    userRepository.postsBy(user)
  }
}
