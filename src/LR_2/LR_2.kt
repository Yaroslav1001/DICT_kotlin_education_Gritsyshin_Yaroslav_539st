import java.time.LocalDate
import java.util.*

fun main() {
//    1. На вході ціле число, повернути рядок “Even” для парного числа та “Odd” в іншому випадку.

    print("Введіть ціле число >")
    val num = readln().toInt()
    val result = if (num % 2 == 0) "Even" else "Odd"
    println(result)

//    2. Помножити задане число на 4, якщо воно парне і на 5 інакше.

    val multiply = if (result == "Even") num * 4 else num * 5
    println(multiply)

//    3. Повернути негативне число. Наприклад, вхід: 1, на виході: -1; для -5 повернути -5.

    val returnNegative = if (num >= 0) num * -1 else num
    println(returnNegative)

//    4. За роком визначити вік. (1 століття охоплює період з 1 по 100 рік включно і т.д.).

    print("Введіть ваш рік народження >")
    val yearOfBirth = readln().toInt()
    val currentYear = LocalDate.now().year
    val age = currentYear - yearOfBirth
    println("Вік: $age!")

//    5. Задано масив цілих чисел, котрому необхідно визначити найменше ціле число.
//    Наприклад, для [34, 15, 88, 2], відповідь 2.

    val numbers: Array<Int> = arrayOf(34, 15, 88, 2, 2, 8)
    val minimumNumbers = numbers.min()
    println(minimumNumbers)

//    6. Задано масив цілих чисел, для якого потрібно знайти два найбільші числа.

    val massive = listOf(1, 5, 87, 45, 8, 8)
    val sortedMassive = massive.sortedDescending()
    println("${sortedMassive[1]}, ${sortedMassive[0]}")

//    7. Даний масив цілих чисел, котрому повернути масив, де перший елемент є
//кількістю позитивних чисел, а другий – сумою негативних чисел. Якщо на
//вході порожній масив або null, необхідно повернути порожній масив.

    val massiveTwo = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14, -15)
    val positiveArray = massiveTwo.filter { it >= 0 }.size
    val negativeArray = massiveTwo.filter { it < 0 }.sum()
    println("$positiveArray, $negativeArray")

//    8. Порахувати кількість голосних букв у рядку (a, e, i, o, u, y голосні).

    print("Введіть рядок на англійській мові > ")
    val input = readlnOrNull() ?: ""

    val vowels = setOf('a', 'e', 'i', 'o', 'u', 'y')
    var count = 0

    for (char in input.lowercase(Locale.getDefault())) {
        if (char in vowels) {
            count++
        }
    }

    println("Кількість голосних букв у рядку: $count")

//    9. Дано рядок, для якого необхідно знайти середній символ. Якщо довжина
//непарна, то повернути середній символ, інакше – поверніть середні 2 символи.

    println("Введіть рядок на англійській мові > ")
    val inputString = readlnOrNull() ?: ""

    val middleIndex = inputString.length / 2

    val resultString = if (inputString.length % 2 == 0) {
        inputString.substring(middleIndex - 1, middleIndex + 1)
    } else {
        inputString[middleIndex].toString()
    }

    println("Середній символ(и): $resultString")

//    10. Створити таблицю множення розміром NxN. Для N = 3:
//1 2 3
//2 4 6
//3 6 9
//Як відповідь має бути [[1,2,3],[2,4,6],[3,6,9]].

    print("Введіть розмір таблиці множення (N): ")
    val n = readlnOrNull()?.toIntOrNull()

    if (n != null && n > 0) {
        val multiplicationTable = Array(n) { IntArray(n) }

        for (i in 0..<n) {
            for (j in 0..<n) {
                multiplicationTable[i][j] = (i + 1) * (j + 1)
            }
        }

        // Виведення таблиці множення
        for (row in multiplicationTable) {
            println(row.joinToString(" "))
        }
    } else {
        println("Некоректне значення для розміру таблиці множення.")
    }
}
