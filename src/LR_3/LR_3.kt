fun main() {
    val randomChoice = listOf("roc", "paper", "scissors")  // створено список варіантів гри
    var round = true  // лічильник для гри (якщо "false", то гра закінчується)
    while (round) {  // цикл гри
        val random = randomChoice.indices.random()  // рандомно обираємо елемент списку посилаючись на його індекс (.indices)
        val choice = randomChoice[random].lowercase()  // отримуємо елемент у вигляді строки, та переводить його до нижнього реєстру
        println("Random choice: $choice\n")
        print(
            "Choose an option from the provided ones\n" +
                    "1.Roc\n2.Paper\n3.Scissors\n> "
        )
        val userChoice = readlnOrNull()?.lowercase()  // зведення введення користувача до нижнього реєстру
        if (userChoice !in randomChoice){  // перевірка на правильний ввід елементів гри
            println("Incorrect input\n")
        } else {
            if (userChoice == choice) {  // умова, при якій збігаються елементи гравців
                print("Draw\n")
            } else if (  // варіанти, при яких користувач виграє
                (userChoice == "roc" && choice == "scissors") ||  //  перевірка одночасно двох умов за допомогою логічного оператора "та(&&)"
                (userChoice == "paper" && choice == "roc") ||  // перевірка на збіг усіх умов за допомогою логічного оператора "або(||)"
                (userChoice == "scissors" && choice == "paper")
            ) {
                println("You win")
                round = false // змінна приймає положення, при якому гра завершується
            } else {
                println("You lose\n")
            }
        }
    }
}

