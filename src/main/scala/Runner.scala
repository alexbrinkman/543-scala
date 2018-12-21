object Runner extends App {
  println("Starting 543")

  val board = new Board(initialBoard)
  println(board)
  board.move(1, 1)
  println(board)

  def initialBoard: Array[Array[Boolean]] = {
    val matrix = Array.ofDim[Boolean](3,5)
    matrix(0)(0) = true
    matrix(0)(1) = true
    matrix(0)(2) = true

    matrix(1)(0) = true
    matrix(1)(1) = true
    matrix(1)(2) = true
    matrix(1)(3) = true

    matrix(2)(0) = true
    matrix(2)(1) = true
    matrix(2)(2) = true
    matrix(2)(3) = true
    matrix(2)(4) = true
    matrix
  }
}
