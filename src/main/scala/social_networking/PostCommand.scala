package social_networking

class PostCommand(command: String, userRepository: UserRepository) extends Command {

  override def execute: Option[List[String]] = {

    val seperateUserAndMessage = command.split(" -> ")
    val user = seperateUserAndMessage(0)
    val message = seperateUserAndMessage(1)

    userRepository.savePost(user, message)

    None
  }
}
