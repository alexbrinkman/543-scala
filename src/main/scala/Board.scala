class Board(var position: Array[Array[Boolean]]) {

  def move(row: Int, num: Int) {
//    validate_move(row, num)
    update_board(row, num)
  }

  def winner: Boolean = {
    total_pieces_left == 1
  }

  def available_moves: Array[Board] = {
    //  # One move for each piece of each row, unless there are only pieces left in one row.
    val boards: Array[Board] = Array.empty[Board]
    val start_at = if (one_row_left) 1 else 0
    for (i <- 0 until position.length) {
      for (j <- start_at until position(i).length) {
        val new_position = position.clone()
        new_position(i) = create_row(j)
        boards +: new_position
      }
    }
    boards
  }

  override def toString: String = {
    val str = StringBuilder.newBuilder
    str.append("---------\n")
    for (i <- 0 until position.length) {
      str.append("row #" + (i + 1) + ": ")
      for (j <- 0 until pieces_left_in_row(i + 1)) {
        str.append("O ")
      }
      str.append("\n")
    }
    str.append("---------\n")
    str.toString()
  }

  private def validate_move(row: Int, num: Int) = {

  }

  private def pieces_left_in_row(row: Int): Int = {
    position(row - 1).count(_ == true)
  }

  private def total_pieces_left: Int = {
    position.flatMap(_.toList).length
  }

  private def one_row_left: Boolean = {
    for (i <- 0 until position.length) {
      if (pieces_left_in_row(i + 1) == total_pieces_left) {
        return true
      }
    }
    false
  }

  private def update_board(row: Int, num: Int): Unit = {
    val number_of_pieces = pieces_left_in_row(row) - num
    val newRow = Array.fill[Boolean](number_of_pieces)(true)
    position(row - 1) = newRow
  }

  private def create_row(pieces: Int): Array[Boolean] = {
    Array.fill[Boolean](pieces)(true)
  }

}