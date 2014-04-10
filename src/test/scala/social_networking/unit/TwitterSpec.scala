package social_networking.unit

import social_networking.Spec.UnitSpec
import social_networking.{Twitter, Console, System}
import org.mockito.Mockito._
import org.mockito.BDDMockito._


class TwitterSpec extends UnitSpec{
   "Application" should {
     "exit console" in {
       val console = mock[Console]
       val system = mock[System]
       val application = new Twitter(console)

       given(console.readline()) willReturn "exit"

       application.start()
       verify(console).println("bye!")

       system.exit
       verify(system).exit
     }
  }
}
