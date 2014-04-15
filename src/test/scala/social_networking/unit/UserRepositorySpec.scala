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

      posts.get shouldBe List(SECOND_POST, FIRST_POST)
    }

    "return only Alices posts" in {
      val userRepository = new UserRepository

      userRepository.savePost(ALICE, FIRST_POST)
      userRepository.savePost(CHARLIE, FIRST_POST)
      userRepository.savePost(ALICE, SECOND_POST)

      val posts = userRepository.postsBy(ALICE)

      posts.get shouldBe List(SECOND_POST, FIRST_POST)
    }
  }

  val ALICE = "ALICE"
  val CHARLIE = "CHARLIE"
  val FIRST_POST = "Alice first post"
  val SECOND_POST = "Alice second post"
}
