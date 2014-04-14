package social_networking

class UserRepository {

  var posts: Seq[(String, String)] = Seq()


  def savePost(user:String, post: String) = {
    posts = (user, post) +: posts
  }

  def postsBy(user: String): Option[List[String]] = {
     Some(posts.map(_._2).toList)
  }
}
