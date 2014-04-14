package social_networking

class PostCommand(command: String, userRepository: UserRepository) extends Command {

  override def execute: Unit = {

    val seperateUserAndMessage = command.split(" -> ")
    val user = seperateUserAndMessage(0)
    val message = seperateUserAndMessage(1)

    userRepository.savePost(user, message)
  }
}
