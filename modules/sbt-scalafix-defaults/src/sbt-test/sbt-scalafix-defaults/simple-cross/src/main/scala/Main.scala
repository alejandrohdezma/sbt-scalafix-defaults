import scala.List
import java.util.UUID
import scala.io.Source

object Main {

  private val int = 42

  def method(parameter1: UUID, parameter2: List[String]) = List(s"$parameter1") ++ parameter2

}
