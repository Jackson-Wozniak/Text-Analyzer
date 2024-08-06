class FileStats {
  private var lineCount: Int = _
  private var wordCount: Int = _
  private var charHistogram: Map[Char, Int] = _
  private var wordHistogram: Map[String, Int] = _
  
  def toJSON: String = {
    val string: StringBuilder = StringBuilder("")
    ""
  }
}
