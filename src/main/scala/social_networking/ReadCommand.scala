package social_networking

class ReadCommand(user: String, userRepository: UserRepository) extends Command {
  override def execute: Option[String] = {
    userRepository.postsBy(user)
    None
  }
}
