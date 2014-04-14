package social_networking.unit

import social_networking.Spec.UnitSpec
import social_networking.{UserRepository, ReadCommand}
import org.mockito.Mockito._

class ReadCommandSpec extends UnitSpec {
  "Read command" should {
    "invoke postsby in user repository" in {
      val readCommand = new ReadCommand(ALICE, userRepository)

      readCommand.execute

      verify(userRepository).postsBy(ALICE)
    }
  }

  val ALICE = "Alice"
  val userRepository = mock[UserRepository]
}
