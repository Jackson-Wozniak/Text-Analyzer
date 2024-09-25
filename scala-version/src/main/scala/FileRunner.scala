import scala.io.{Codec, Source}
import scala.util.Using
import JSONUtils.*

import java.io.{FileWriter, PrintWriter}

object FileRunner {
  private val INPUT_MANAGER_FILE: String = "text_files/input_files.txt"
  val OUTPUT_MANAGER_FILE: String = "text_files/output_files.txt"

  /*
  Components:
    FileReader -> object that reads a file from path, and all related statistics
    FileWriter -> object that writes the stats to a new file
    Utils -> shared utilities
    TextRunner/Manager -> handles the read/writes of all files in the input
   */
  def main(args: Array[String]): Unit = {
    new PrintWriter(FileRunner.OUTPUT_MANAGER_FILE).close()

    val fileAnalyzers: List[FileAnalyzer] = FileRunner.fileAnalyzers
    fileAnalyzers
      .map(analyzer => new StatWriter(analyzer.stats, analyzer.filename))
      .foreach { writer =>
        writer.appendToOutputManager()
        writer.writeStatistics()
      }
    new FileAggregator(fileAnalyzers).writeStatistics()
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
