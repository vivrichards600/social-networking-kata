package social_networking.unit

import social_networking.Spec.UnitSpec
import social_networking.UserRepository

class UserRepositorySpec extends UnitSpec {
  "User repository" should {
    "return posts from Alice in reverse chronological order" in {
      val userRepository = new UserRepository

      userRepository.savePost(ALICE, FIRST_POST)
      userRepository.savePost(ALICE, SECOND_POST)

      val posts = userRepository.postsBy(ALICE)

      posts.get shouldBe List("Alice - " + SECOND_POST, "Alice - " + FIRST_POST)
    }

    "return only Alices posts" in {
      val userRepository = new UserRepository

      userRepository.savePost(ALICE, FIRST_POST)
      userRepository.savePost(CHARLIE, FIRST_POST)
      userRepository.savePost(ALICE, SECOND_POST)

      val posts = userRepository.postsBy(ALICE)

      posts.get shouldBe List("Alice - " + SECOND_POST, "Alice - " + FIRST_POST)
    }
  }

  val ALICE = "Alice"
  val CHARLIE = "Charlie"
  val FIRST_POST = "first post"
  val SECOND_POST = "second post"
}
