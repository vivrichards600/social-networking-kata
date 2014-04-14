package social_networking.unit

import social_networking.Spec.UnitSpec
import org.mockito.Mockito._
import social_networking.{PostCommand, UserRepository}

class PostCommandSpec extends UnitSpec {
  "Post command" should {
    "identify a user" in {

      val postCommand = new PostCommand("Alice -> Hello", userRepository)

      postCommand.execute

      verify(userRepository).savePost(List("Alice", "Hello"))
      //TODO: Discuss this test

      // READ COMMAND
      //val posts = userRepository.postsBy("ALice")
      //posts should beEqual(List("Hello"))

      //THEN POSTS BY
    }
  }

//  "Post command" should {
//    "identify a post" in {
//
//    }
//  }

  val userRepository = mock[UserRepository]
}
