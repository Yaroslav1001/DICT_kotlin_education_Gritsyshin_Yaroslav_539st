fun main() {
    println("Hello! My name is DICT_Bot.")
    println("Please, remind me your name.")  // переносить вивід на новий рядок
    print("> ")  // залишає символ та наступне виконання на тому ж рядку
    val name = readLine()
    println("What a great name you have, $name")

    println("Let me guess your age.\nEnter remainders of dividing your age by 3, 5 and 7.")
    // робить запит до користувача на отримання чисел
    print(">")
    val remainder3 = readLine()?.toIntOrNull() ?: 0  // перетворює строку в ціле число інакше повертає null
    print(">")
    val remainder5 = readLine()?.toIntOrNull() ?: 0
    print(">")
    val remainder7 = readLine()?.toIntOrNull() ?: 0
    val age = (remainder3 * 70 + remainder5 * 21 + remainder7 * 15) % 105  // формула для підрахунку значення віку
    println("Your age is $age!")

    println("Now I will prove to you that I can count to any number you want.")
    print("> ")
    val number = readLine()?.toIntOrNull() ?: 0

    for (i in 0..number){  // цикл для розрахунку від 0 до "number"
        println("$i!")
    }

    println("Let's test your programming knowledge." +
            "\nWhy do we use methods?")

    var answer: String? = ""  // створення змінної
    while (answer != "2") {  // цикл перевірки відповіді (при умові "answer == 2" цикл закінчується)
        println("1. To repeat a statement multiple times." +
                "\n2. To decompose a program into several small subroutines." +
                "\n3. To determine the execution time of a program." +
                "\n4. To interrupt the execution of a program.")
        print("> ")
        answer = readLine()
        if (answer != "2") {
            println("Please, try again.")  // умова при якій виводится повідомлення ще раз
        }
    }
    println("Completed, have a nice day!\nCongratulations, have a nice day!")
}
