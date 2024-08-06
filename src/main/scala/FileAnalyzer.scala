class FileAnalyzer(val filename: String){
  private val INPUT_PATH: String = "text_files/input/"
  var stats: FileStats = new FileStats

  analyze()

  private def analyze(): Unit = {
    stats.lineCount = lineCount
    stats.wordCount = wordCount
    stats.wordHistogram = wordHistogram
    stats.charHistogram = charHistogram
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
