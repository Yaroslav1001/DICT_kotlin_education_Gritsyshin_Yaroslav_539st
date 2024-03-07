fun main() {
    println("Enter the number of rows")
    print("> ")
    val numRows = readLine()!!.toInt()

    println("Enter the number of seats in each row")
    print("> ")
    val numCols = readLine()!!.toInt()

    // Створення порожнього двомірного масиву
    val matrix = Array(numRows) { Array(numCols) { "S" } }

    var purchasedTickets = 0
    var currentIncome = 0

    fun showSeats() {
        println("Cinema:")
        // Вывод номеров столбцов
        print("  ")
        repeat(numCols) { colIndex ->
            print("${colIndex + 1} ")
        }
        println()

        // Вывод двумерного массива с номерами строк и содержимым
        for (rowIndex in matrix.indices) {
            print("${rowIndex + 1} ") // Нумерация строк начинается с 1, а не с 0
            for (colIndex in matrix[rowIndex].indices) {
                print(matrix[rowIndex][colIndex] + " ")
            }
            println()
        }
    }

    fun buyTicket() {
        while (true) {
            println("Enter a row number")
            print("> ")
            val selectRow = readLine()!!.toInt() - 1
            println("Enter a seat number in that row")
            print("> ")
            val selectSeat = readLine()!!.toInt() - 1

            if (selectRow in 0 until numRows && selectSeat in 0 until numCols) {
                if (matrix[selectRow][selectSeat] == "B") {
                    println("That ticket has already been purchased!")
                } else {
                    val ticketPrice = if (numRows * numCols <= 60 || selectRow < numRows / 2) 10 else 8
                    println("Ticket price: $$ticketPrice")
                    matrix[selectRow][selectSeat] = "B"
                    purchasedTickets++
                    currentIncome += ticketPrice
                    break
                }
            } else {
                println("Wrong input!")
            }
        }
    }

    fun showStatistics() {
        val totalSeats = numRows * numCols
        val percentage = purchasedTickets.toDouble() / totalSeats * 100
        val totalIncome = if (totalSeats <= 60) totalSeats * 10 else ((numRows / 2) * numCols * 10) + ((numRows - numRows / 2) * numCols * 8)

        println("Number of purchased tickets: $purchasedTickets")
        println("Percentage: %.2f".format(percentage) + "%")
        println("Current income: $$currentIncome")
        println("Total income: $$totalIncome")
    }

    while (true) {
        println("\n1. Show the seats")
        println("2. Buy a ticket")
        println("3. Statistics")
        println("0. Exit")

        print("> ")
        when (readLine()!!.toInt()) {
            1 -> showSeats()
            2 -> buyTicket()
            3 -> showStatistics()
            0 -> return
            else -> println("Invalid option! Please try again.")
        }
    }
}
