import scala.io.{Codec, Source}
import scala.util.Using
import JSONUtils._

object FileRunner {
  private val INPUT_MANAGER_FILE: String = "text_files/input_files.txt"

  /*
  Components:
    FileReader -> object that reads a file from path, and all related statistics
    FileWriter -> object that writes the stats to a new file
    Utils -> shared utilities
    TextRunner/Manager -> handles the read/writes of all files in the input
   */
  def main(args: Array[String]): Unit = {
    fileAnalyzers
      .map(analyzer => new StatWriter(analyzer.stats, analyzer.filename))
      .foreach { writer =>
        writer.appendToOutputManager()
        writer.writeStatistics()
      }
  }

  private def fileAnalyzers: List[FileAnalyzer] =
    def inputFileNames: List[String] =
      Using(Source.fromFile(INPUT_MANAGER_FILE)) { file =>
        file.getLines()
          .filter(_.nonEmpty)
          .toList
      }.getOrElse(List.empty[String])
    inputFileNames.map(filename => new FileAnalyzer(filename))
}
