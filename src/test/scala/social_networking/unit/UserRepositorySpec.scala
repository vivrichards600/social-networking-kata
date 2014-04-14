package social_networking.unit

import social_networking.Spec.UnitSpec
import social_networking.UserRepository
import org.mockito.BDDMockito._

class UserRepositorySpec extends UnitSpec {
  "User repository" should {
    "return posts from Alice in reverse chronological order" in {
      val userRepository = new UserRepository

      userRepository.savePost("Alice","A Post")
      userRepository.savePost("Alice","Another Post")

      val posts = userRepository.postsBy("Alice")

      posts.get shouldBe List("Another Post", "A Post")
    }

    "return only Alices posts" in {
      val userRepository = new UserRepository

      userRepository.savePost("Alice","A post")
      userRepository.savePost("Charlie","Another post")
      userRepository.savePost("Alice","My second post")

      val posts = userRepository.postsBy("Alice")

      posts.get shouldBe List("My second post", "A post")
    }
  }
}
