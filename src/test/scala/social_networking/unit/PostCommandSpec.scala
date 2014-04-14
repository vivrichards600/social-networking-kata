package social_networking.unit

import social_networking.Spec.UnitSpec
import org.mockito.Mockito._
import social_networking.{PostCommand, UserRepository}

class PostCommandSpec extends UnitSpec {
  "Post command" should {
    "identify a user and message" in {
      val postCommand = new PostCommand("Alice -> Hello", userRepository)

      postCommand.execute

      verify(userRepository).savePost(List("Alice", "Hello"))
    }
  }

  val userRepository = mock[UserRepository]
}
