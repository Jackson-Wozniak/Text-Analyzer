import java.io.{FileWriter, PrintWriter}
import java.nio.charset.StandardCharsets
import java.nio.file.{Files, StandardOpenOption}

class StatWriter(val stats: FileStats, val filename: String){
  private val OUTPUT_MANAGER_FILE: String = "text_files/output_files.txt"
  private val OUTPUT_PATH: String = "text_files/output/"

  def appendToOutputManager(): Unit = {
    val fileWriter = new FileWriter(OUTPUT_MANAGER_FILE, true)
    val writer = new PrintWriter(fileWriter)

    try writer.write(filename + "\n")
    finally writer.close()
  }

  def writeStatistics(): Unit = {

  }
}
