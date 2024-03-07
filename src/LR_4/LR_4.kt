fun main() {
    println("Enter the number of rows")
    print("> ")
    val numRows = readln().toInt()

    println("Enter the number of seats in each row")
    print("> ")
    val numCols = readln().toInt()

    // Створення порожнього двомірного масиву
    val matrix = Array(numRows) { Array(numCols) { "S" } }

    var purchasedTickets = 0 // Ініціалізуємо лічильник куплених квитків
    var currentIncome = 0 // Ініціалізуємо змінну для поточного доходу

    // Функція для відображення доступних місць
    fun showSeats() {
        println("Cinema:")
        // Вывод номеров столбцов
        print("  ")
        repeat(numCols) { colIndex -> // Повторюємо для кожного стовпця
            print("${colIndex + 1} ") // Виводимо номер стовпця
        }
        println()

        // Вывод двумерного массива с номерами строк и содержимым
        for (rowIndex in matrix.indices) { // Перебираємо рядки
            print("${rowIndex + 1} ") // Нумерация строк начинается с 1, а не с 0
            for (colIndex in matrix[rowIndex].indices) { // Перебираємо місця в рядку
                print(matrix[rowIndex][colIndex] + " ") // Виводимо стан кожного місця
            }
            println()
        }
    }

    // Функція для купівлі квитка
    fun buyTicket() {
        while (true) { // Нескінченний цикл для введення даних
            println("Enter a row number")
            print("> ")
            val selectRow = readLine()!!.toInt() - 1 // Зчитуємо номер рядка з консолі та зменшуємо на 1 для коректної індексації масиву
            println("Enter a seat number in that row")
            print("> ")
            val selectSeat = readLine()!!.toInt() - 1 // Зчитуємо номер місця з консолі та зменшуємо на 1 для коректної індексації масиву

            if (selectRow in 0 until numRows && selectSeat in 0 until numCols) { // Перевіряємо, чи введені значення знаходяться в межах дійсного діапазону
                if (matrix[selectRow][selectSeat] == "B") { // Перевіряємо, чи вибране місце вже продано
                    println("That ticket has already been purchased!") // Виводимо повідомлення про вже куплений квиток
                } else {
                    val ticketPrice = if (numRows * numCols <= 60 || selectRow < numRows / 2) 10 else 8 // Визначаємо ціну квитка залежно від розміру кінотеатру та розташування місця
                    println("Ticket price: $$ticketPrice") // Виводимо ціну квитка
                    matrix[selectRow][selectSeat] = "B" // Позначаємо місце як продане
                    purchasedTickets++ // Збільшуємо лічильник куплених квитків
                    currentIncome += ticketPrice // Додаємо до поточного доходу ціну квитка
                    break // Виходимо з циклу, оскільки квиток куплений
                }
            } else {
                println("Wrong input!") // Умова для попередження про некоректний ввід
            }
        }
    }

    // Функція для відображення статистики
    fun showStatistics() {
        val totalSeats = numRows * numCols // Загальна кількість місць
        val percentage = purchasedTickets.toDouble() / totalSeats * 100 // Відсоток зайнятих місць
        val totalIncome = if (totalSeats <= 60) totalSeats * 10 else ((numRows / 2) * numCols * 10) + ((numRows - numRows / 2) * numCols * 8) // Формула для розрахунку загального доходу

        println("Number of purchased tickets: $purchasedTickets")
        println("Percentage: %.2f".format(percentage) + "%")
        println("Current income: $$currentIncome")
        println("Total income: $$totalIncome")
    }

    while (true) { // Нескінченний цикл для виведення меню
        println("\n1. Show the seats")
        println("2. Buy a ticket")
        println("3. Statistics")
        println("0. Exit")

        print("> ")
        when (readln().toInt()) { // конструкція для виконання дії залежно від вводу користувача
            1 -> showSeats() // викликається функція відображення місць
            2 -> buyTicket() // викликається функція купівлі квитка
            3 -> showStatistics() // викликається функція відображення статистики
            0 -> return // програма завершується
            else -> println("Invalid option! Please try again.") // Якщо введено неправильний варіант
        }
    }
}
