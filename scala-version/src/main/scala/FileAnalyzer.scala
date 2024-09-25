import scala.io.{Codec, Source}
import scala.util.Using

class FileAnalyzer(val filename: String){
  private val INPUT_PATH: String = "text_files/input/"
  var stats: FileStats = new FileStats

  analyze()

  private def analyze(): Unit = {
    populateStats()
  }
  
  private def populateStats(): Unit = {
    def processLine(line: String): Unit = {
      val words: Array[String] = line.split(" ")
      stats.wordCount += words.length
      words.foreach(stats.addToMap(_))
    }
    
    Using(Source.fromFile(INPUT_PATH + filename)) { file =>
      file.getLines()
        .foreach(line => {
          stats.lineCount += 1
          processLine(line)
        })
    }
  }

  private def lineCount: Int =
    0

  private def wordCount: Int =
    0

  private def wordHistogram: Map[String, Int] =
    Map()

  private def charHistogram: Map[Char, Int] =
    Map()
}
