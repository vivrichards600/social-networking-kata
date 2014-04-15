package social_networking.unit

import social_networking.Spec.UnitSpec
import social_networking.UserRepository

class UserRepositorySpec extends UnitSpec {
  "User repository" should {
    "return posts from Alice in reverse chronological order" in {
      val userRepository = new UserRepository

      userRepository.savePost(ALICE, FIRST_MESSAGE)
      userRepository.savePost(ALICE, SECOND_MESSAGE)

      val posts = userRepository.postsBy(ALICE)

      posts.get shouldBe List(SECOND_POST, FIRST_POST)
    }

    "return only Alices posts" in {
      val userRepository = new UserRepository

      userRepository.savePost(ALICE, FIRST_MESSAGE)
      userRepository.savePost(CHARLIE, FIRST_MESSAGE)
      userRepository.savePost(ALICE, SECOND_MESSAGE)

      val posts = userRepository.postsBy(ALICE)

      posts.get shouldBe List(SECOND_POST, FIRST_POST)
    }
  }

  val ALICE = "Alice"
  val CHARLIE = "Charlie"
  val FIRST_MESSAGE = "first post"
  val SECOND_MESSAGE = "second post"
  val FIRST_POST = ALICE + " - " + FIRST_MESSAGE
  val SECOND_POST = ALICE + " - " + SECOND_MESSAGE
}
