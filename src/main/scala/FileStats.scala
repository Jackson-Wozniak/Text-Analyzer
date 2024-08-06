import JSONUtils._

class FileStats {
  var lineCount: Int = 0
  var wordCount: Int = 0
  var charHistogram: Map[Char, Int] = Map.empty[Char, Int]
  var wordHistogram: Map[String, Int] = Map.empty[String, Int]

  def toJSON: String = {
    val string: StringBuilder = StringBuilder()
    val indentation = 4

    string.append("{\n")
      .append(" " * indentation)
        .append("\"lineCount\" : ")
        .append(lineCount)
        .append(",\n")
      .append(" " * indentation)
        .append("\"wordCount\" : ")
        .append(wordCount)
        .append(",\n")
      .append(" " * indentation)
        .append("\"wordHistogram\" : ")
        .append(wordHistogram.toJSON(indentation))
        .append(",\n")
      .append(" " * indentation)
        .append("\"charHistogram\" : ")
        .append(charHistogram.toJSON(indentation))
      .append("\n}")
      .toString()
  }
}
