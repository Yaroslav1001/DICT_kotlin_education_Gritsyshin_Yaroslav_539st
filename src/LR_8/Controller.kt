package LR_8

import CoffeeMachine
import Resources
import TerminalOutput

object CoffeeMachineController {
    private val coffeeMachine = CoffeeMachine(Resources(400, 540, 120, 9, 550))

    fun start() {
        while (true) {
            TerminalOutput.show("Write action (buy, fill, take, remaining, exit):")
            print("> ")

            when (readlnOrNull()?.trim()) {
                "buy" -> buyCoffee()
                "fill" -> fillIngredients()
                "take" -> takeMoney()
                "remaining" -> showRemaining()
                "exit" -> return
                else -> TerminalOutput.show("Invalid choice!")
            }
        }
    }

    private fun buyCoffee() {
        TerminalOutput.show("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back – to main menu:")
        print("> ")
        val type = readlnOrNull()?.trim() ?: ""
        TerminalOutput.show(coffeeMachine.buy(type))
    }

    private fun fillIngredients() {
        println("\nWrite how many ml of water do you want to add:")
        print("> ")
        val water = readlnOrNull()?.toIntOrNull() ?: 0
        println("Write how many ml of milk do you want to add:")
        print("> ")
        val milk = readlnOrNull()?.toIntOrNull() ?: 0
        println("Write how many grams of coffee beans do you want to add:")
        print("> ")
        val coffeeBeans = readlnOrNull()?.toIntOrNull() ?: 0
        println("Write how many disposable cups of coffee do you want to add:")
        print("> ")
        val disposableCups = readlnOrNull()?.toIntOrNull() ?: 0
        coffeeMachine.fill(Resources(water, milk, coffeeBeans, disposableCups))
        println("Ingredients filled.")
    }

    private fun takeMoney() {
        val message = coffeeMachine.take()
        println(message)
    }

    private fun showRemaining() {
        val message = coffeeMachine.remaining()
        println(message)
    }
}