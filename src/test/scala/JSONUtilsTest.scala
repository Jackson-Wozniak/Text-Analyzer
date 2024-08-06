import org.scalatest.funsuite.AnyFunSuite
import JSONUtils._

open class JSONUtilsTest extends AnyFunSuite:
  test("Map[String, Int] tests"):
    val emptyMap: Map[String, Int] = Map.empty[String, Int]
    val map1 = Map[String, Int]("String 1" -> 1, "String 2" -> 2, "String 1291" -> 1291)
    val string1: String =
      "{\n" +
      "    \"String 1\" : 1,\n" +
      "    \"String 2\" : 2,\n" +
      "    \"String 1291\" : 1291\n" +
      "}"
    assert(map1.toJSON == string1)
