package social_networking.unit

import social_networking.Spec.UnitSpec
import social_networking.{UserRepository, ReadCommand}
import org.mockito.BDDMockito._

class ReadCommandSpec extends UnitSpec {
  "Read command" should {
    "retrieve a post from Alice" in {
      given(userRepository.postsBy(ALICE)) willReturn(Some(List(A_POST)))

      readCommand.execute should be (Some(List(A_POST)))
    }
  }

  "Read command" should {
    "retrieve many posts from Alice" in {
      given(userRepository.postsBy(ALICE)) willReturn(Some(List(MANY_POSTS)))

      readCommand.execute should be (Some(List(MANY_POSTS)))
    }
  }

  val ALICE = "Alice"
  val A_POST = "A Post"
  val ANOTHER_POST = "Another Post"
  val MANY_POSTS = A_POST + " " + ANOTHER_POST
  val userRepository = mock[UserRepository]
  val readCommand = new ReadCommand(ALICE, userRepository)
}
