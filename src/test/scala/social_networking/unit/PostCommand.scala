package social_networking.unit

import social_networking.Spec.UnitSpec
import org.mockito.Mockito._

class PostCommand extends UnitSpec {
  "Post command" should {
    "identify a user" in {

      val postCommand = new PostCommand("Alice -> Hello")

      postCommand.execute

      verify(userRepository).savePost("Alice", "Hello")


      // READ COMMAND
      val posts = userRepository.postsBy("ALice")
      posts should beEqual(List("Hello"))

      //THEN POSTS BY
    }
  }

//  "Post command" should {
//    "identify a post" in {
//
//    }
//  }

  val userRepository = new UserRepository
}
