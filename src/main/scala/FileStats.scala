import JSONUtils.*

import scala.collection.mutable

class FileStats {
  var lineCount: Int = 0
  var wordCount: Int = 0
  private val charHistogram: mutable.Map[Char, Int] = mutable.Map.empty[Char, Int]
  private val wordHistogram: mutable.Map[String, Int] = mutable.Map.empty[String, Int]

  def addToMap(word: String): Unit = {
    wordHistogram += word -> (wordHistogram.getOrElse(word, 0) + 1)
    word.foreach(addToMap)
  }

  private def addToMap(ch: Char): Unit = {
    val char = ch.toLower
    charHistogram += char -> (charHistogram.getOrElse(char, 0) + 1)
  }

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
