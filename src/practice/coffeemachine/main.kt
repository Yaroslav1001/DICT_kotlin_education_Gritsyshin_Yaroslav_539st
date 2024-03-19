package practice.coffeemachine

class CoffeeMachine(
    private var water: Int,
    private var milk: Int,
    private var coffee: Int,
    private var cups: Int,
    private var money: Int
){
    fun remaining(){
        println("""
            
            The coffee machine has:
            $water of water
            $milk of milk
            $coffee of coffee beans
            $cups of disposable cups
            $money of money
            
        """.trimIndent())
    }

    fun buy(type: String){
        var notEnought = ""
        if (cups < 1) notEnought += "disposable cups"
        when (type) {
            "1", "espresso" -> {
                if (water < 250) notEnought += "water"
                if (coffee < 16) notEnought += "coffee beans"
                if (water >= 250 && coffee >= 16 && cups >= 1){
                    println("I have enough resources, making you a coffee!")
                    money += 4
                    water -= 250
                    coffee -= 16
                    cups -= 1
                } else{
                    println("Sorry, not enough ${notEnought}!")
                }
            }
            "2", "latte" -> {
                if (water < 350) notEnought += "water"
                if (milk < 75) notEnought += "milk"
                if (coffee < 20) notEnought += "coffee beans"
                if (water >= 350 && milk >= 75 && coffee >= 20 && cups >= 1) {
                    println("I have enough resources, making you a coffee!")
                    money += 7
                    water -= 350
                    milk -= 75
                    coffee -= 20
                    cups -= 1
                } else{
                    println("Sorry, not enough ${notEnought}!")
                }
            }
            "3", "cappuccino" -> {
                if (water < 200) notEnought += "water"
                if (milk < 100) notEnought += "milk"
                if (coffee < 12) notEnought += "coffee beans"
                if (water >= 200 && milk >= 100 &&  coffee >= 12 && cups >= 1){
                    println("I have enough resources, making you a coffee!")
                    money += 6
                    water -= 200
                    milk -= 100
                    coffee -= 12
                    cups -= 1
                } else{
                    println("Sorry, not enough ${notEnought}!")
                }
            }
            "back" -> { return }

            else -> println("Invalid choice!")
        }
    }

    fun fill(addWater: Int, addMilk: Int, addCoffee: Int, addCups: Int){
        water += addWater
        milk += addMilk
        coffee += addCoffee
        cups += addCups
    }

    fun take(){
        println("I gave you $money")
        money = 0
    }

}

fun main() {

    val coffeeMachine = CoffeeMachine(400, 540, 120, 9, 550)
    while (true) {
        println("Write action (buy, fill, take,remaining, exit):")
        print("> ")
        when (readln().trim()) {
            "buy" -> {
                println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back – to main menu:")
                print("> ")
                coffeeMachine.buy(readln().trim())
            }

            "fill" -> {
                println("\nWrite how many ml of water do you want to add:")
                print("> ")
                val water = readln().toInt()
                println("Write how many ml of milk do you want to add:")
                print("> ")
                val milk = readln().toInt()
                println("Write how many grams of coffee beans do you want to add:")
                print("> ")
                val coffee = readln().toInt()
                println("Write how many disposable cups of coffee do you want to add:")
                print("> ")
                val cups = readln().toInt()
                coffeeMachine.fill(water, milk, coffee, cups)
            }

            "take" -> {
                coffeeMachine.take()
            }

            "remaining" -> {
                coffeeMachine.remaining()
            }

            "exit" -> {
                return
            }

            else -> println("Invalid choice!")
        }
    }
}