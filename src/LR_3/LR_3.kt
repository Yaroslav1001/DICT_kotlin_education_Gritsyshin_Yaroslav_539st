fun main() {
    val randomChoice = listOf("rock", "paper", "scissors")  // створено список варіантів гри
    while (true) {  // нескінченний цикл гри
        val random = randomChoice.indices.random()  // рандомно обираємо елемент списку посилаючись на його індекс (.indices)
        val choice = randomChoice[random].lowercase()  // отримуємо елемент у вигляді строки, та переводить його до нижнього реєстру
        print(
            "Choose an option from the provided ones:\n" +
                    "Rock\nPaper\nScissors\n!exit - to end the game\n> "
        )
        val userChoice = readlnOrNull()?.lowercase()  // зведення введення користувача до нижнього реєстру
        if (userChoice == "!exit") { // умова для виходу з гри
            println("Exiting the game...")
            break
        }
        if (userChoice !in randomChoice){  // перевірка на правильний ввід елементів гри
            println("Incorrect input\n")
        } else {
            println("Enemy selection : $choice\n")
            if (userChoice == choice) {  // умова, при якій збігаються елементи гравців
                println("Draw\n")
            } else if (  // варіанти, при яких користувач виграє
                (userChoice == "rock" && choice == "scissors") ||  //  перевірка одночасно двох умов за допомогою логічного оператора "та(&&)"
                (userChoice == "paper" && choice == "rock") ||  // перевірка на збіг усіх умов за допомогою логічного оператора "або(||)"
                (userChoice == "scissors" && choice == "paper")
            ) {
                println("You win")
            } else {
                println("You lose\n")
            }
        }
    }
}

