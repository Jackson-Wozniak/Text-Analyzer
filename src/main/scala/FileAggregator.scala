import JSONUtils.*

import java.io.{File, FileWriter}
import scala.collection.mutable

class FileAggregator(files: List[FileAnalyzer]){
  private val FILES_TOTAL_PATH = "text_files/total_stats.txt"

  private val wordCount = files.foldLeft(0)((accumulator, file) => accumulator + file.stats.wordCount)
  private val lineCount = files.foldLeft(0)((accumulator, file) => accumulator + file.stats.lineCount)
  private val combinedCharHistogram: Map[Char, Int] = mapTotals[Char](files.map(_.stats.charHistogram))
  private val combinedWordHistogram: Map[String, Int] = mapTotals[String](files.map(_.stats.wordHistogram))

  private def mapTotals[K](histograms: List[mutable.Map[K, Int]]): Map[K, Int] = {
    histograms.flatten.groupMapReduce(_._1)(_._2)(_ + _)
  }

  private def toJSON: String = {
    val string: StringBuilder = StringBuilder()
    val indentation = 4

    string.append("{\n")
      .append(" " * indentation)
      .append("\"totalLines\" : ")
      .append(lineCount)
      .append(",\n")
      .append(" " * indentation)
      .append("\"totalWords\" : ")
      .append(wordCount)
      .append(",\n")
      .append(" " * indentation)
      .append("\"allWordHistograms\" : ")
      .append(combinedWordHistogram.toJSON(indentation))
      .append(",\n")
      .append(" " * indentation)
      .append("\"allCharHistograms\" : ")
      .append(combinedCharHistogram.toJSON(indentation))
      .append("\n}")
      .toString()
  }

  def writeStatistics(): Unit = {
    val fileWriter = new FileWriter(new File(FILES_TOTAL_PATH))
    fileWriter.write(toJSON)
    fileWriter.close()
  }
}
