package practice.coffeemachine

class Coffemachine(
    private var water: Int,
    private var milk: Int,
    private var coffee: Int,
    private var cups: Int,
    private var money: Int
){
    fun printStatus(){
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
        when (type) {
            "1", "espresso" -> {
                if (water >= 250 && coffee >= 16 && cups >= 1){
                    money += 4
                    water -= 250
                    coffee -= 16
                    cups -= 1
                }
            }
            "2", "latte" -> {
                if (water >= 350 && milk >= 75 && coffee >= 20 && cups >= 1) {
                    money += 7
                    water -= 350
                    milk -= 75
                    coffee -= 20
                    cups -= 1
                }
            }
            "3", "cappuccino" -> {
                if (water >= 200 && milk >= 100 &&  coffee >= 12 && cups >= 1){
                    money += 6
                    water -= 200
                    milk -= 100
                    coffee -= 12
                    cups -= 1
                }
            }
            else -> println("Invalid choice!")
        }
        printStatus()
    }

    fun fill(addWater: Int, addMilk: Int, addCoffee: Int, addCups: Int){
        water += addWater
        milk += addMilk
        coffee += addCoffee
        cups += addCups
        printStatus()
    }

    fun take(){
        println("I gave you $money")
        money = 0
        printStatus()
    }

}

fun main(){

    val coffeeMachine = Coffemachine(400, 540, 120, 9, 550)
    coffeeMachine.printStatus()
    while (true){
        println("Write action (buy, fill, take):")
        print("> ")
        when(readln().trim()){
            "buy" -> {
                println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:")
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
            else -> println("Invalid choice!")
        }
    }


}