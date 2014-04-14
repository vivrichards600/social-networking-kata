package social_networking.unit

import social_networking.Spec.UnitSpec
import social_networking.UserRepository

class UserRepositorySpec extends UnitSpec {
  "Save post" should {
    "save a user and message to the repository" in {
      val userRepository = new UserRepository
      val POST = List("Alice", "Hello")

      userRepository.savePost(POST)



    }
  }
}