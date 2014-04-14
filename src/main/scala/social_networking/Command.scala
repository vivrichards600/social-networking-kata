package social_networking

abstract class Command  {
  def execute() : Option[List[String]]
}
