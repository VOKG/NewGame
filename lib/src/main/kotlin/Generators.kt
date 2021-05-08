typealias Generators = (Int) -> Coordinate

fun rowCoordinateGenerator(rowNumber: Int): Generators = { index -> Coordinate(x = rowNumber, y = index) }
fun colCoordinateGenerator(colNumber: Int): Generators = { index -> Coordinate(x = index, y = colNumber) }
fun qadCoordinateGenerator(qadNumber: Int): Generators = { index ->
    val x = 3 * (qadNumber / 3) + index / 3
    val y = 3 * (qadNumber % 3) + index % 3
    Coordinate(x, y)
}