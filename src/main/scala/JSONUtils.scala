object JSONUtils {
  implicit class MapExtension[K](val map: Map[K, Int]) extends AnyVal {
    def toJSON: String = toJSON()

    def toJSON(indentOffset: Int = 0): String =
      val indentStr = " " * (indentOffset + 4)
      val initialIndent = " " * indentOffset
      val entries = map.map((key, value) => s"""$indentStr"$key" : $value""").mkString(",\n")
      s"{\n$entries\n$initialIndent}"
  }
}
