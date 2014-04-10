package social_networking

class Twitter(console: Console) {

  def start() = {
    var userCommand = ""
    prompt
    while (userCommand != "exit") {

      userCommand = console.readline()

      if (userCommand == "exit") {
        console println "bye!"
        
//      } else if (userCommand is a post command) {
//        create user if new user
//        add post to the user
//      } else if (userCommand is a read command) {
//        val user = first part of the userCommand (whatever comes before wall)
//        val msgs = messagesFrom(user)
//        console println(msgs[2])
//        console println(msgs[1])
//        prompt

      } else {
        prompt
      }

    }
  }

  private def prompt {
    console print("> ")
  }

}





object Twitter extends App {

  val console = new Console
  val twitter = new Twitter(console)

  twitter start

}