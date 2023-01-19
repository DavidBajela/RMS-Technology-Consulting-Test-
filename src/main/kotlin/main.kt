fun findProductv1(grid: Array<IntArray>, length: Int): Long {
    var loops = 0
    var product = 0L
    var a: Int
    var b: Int
    var c: Int
    var d: Int
    for (y in 0 until length) {
        for (x in 0 until length) {
            //check horizontals
            if (x + 2 < length) {
                a = grid[x][y] * grid[x + 1][y] * grid[x + 2][y]
                loops++
            } else a = 0
            //check verticals
            if (y + 2 < length) {
                b = grid[x][y] * grid[x][y + 1] * grid[x][y + 2]
                loops++
            } else b = 0
            //check diagonals
            if (y + 2 < length && x + 2 < length) {
                c = grid[x][y] * grid[x + 1][y + 1] * grid[x + 2][y + 2]
                d = grid[x + 2][y] * grid[x + 1][y + 1] * grid[x][y + 2]
                loops += 2
            } else {
                c = 0
                d = 0
            }
            product = product.coerceAtLeast(d.coerceAtLeast(a).coerceAtLeast(b.coerceAtLeast(c)).toLong())

        }
    }
    println("number of cycles = $loops")
    return product
}

//288
fun main() {
    val gid = arrayOf(
        intArrayOf(8, 2, 22, 97, 35, 15, 0, 40, 0, 75),
        intArrayOf(49, 49, 99, 40, 17, 81, 18, 57, 60, 87),
        intArrayOf(81, 49, 31, 73, 55, 79, 14, 29, 94, 71),
        intArrayOf(52, 70, 95, 23, 4, 60, 11, 42, 69, 24),
        intArrayOf(22, 31, 16, 71, 51, 67, 63, 89, 41, 92),
        intArrayOf(24, 47, 32, 60, 99, 3, 45, 2, 44, 75),
        intArrayOf(32, 98, 81, 28, 68, 2, 62, 12, 20, 95),
        intArrayOf(67, 26, 20, 68, 2, 62, 12, 20, 95, 63),
        intArrayOf(24, 55, 58, 5, 66, 73, 99, 26, 97, 17),
        intArrayOf(21, 36, 23, 9, 75, 0, 76, 44, 20, 45)
    )
    print(
        findProductv1(gid, 10)
    )
}