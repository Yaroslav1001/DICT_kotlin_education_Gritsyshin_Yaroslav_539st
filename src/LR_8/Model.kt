data class Resources(
    val water: Int = 0,
    val milk: Int = 0,
    val coffeeBeans: Int = 0,
    val disposableCups: Int = 0,
    val money: Int = 0

)

class CoffeeMachine(private var resources: Resources) {

    fun remaining(): String {
        return """
            The coffee machine has:
            ${resources.water} of water
            ${resources.milk} of milk
            ${resources.coffeeBeans} of coffee beans
            ${resources.disposableCups} of disposable cups
            ${resources.money} of money
        """.trimIndent()
    }

    fun buy(type: String): String {
        var notEnough = ""
        when (type) {
            "1", "espresso" -> {
                if (resources.water < 250) notEnough += "water, "
                if (resources.coffeeBeans < 16) notEnough += "coffee beans, "
                if (resources.disposableCups < 1) notEnough += "disposable cups, "
                if (resources.water >= 250 && resources.coffeeBeans >= 16 && resources.disposableCups >= 1) {
                    resources = Resources(
                        resources.water - 250,
                        resources.milk,
                        resources.coffeeBeans - 16,
                        resources.disposableCups - 1,
                        resources.money + 4

                    )
                    return "I have enough resources, making you a coffee!"
                }
            }
            "2", "latte" -> {
                if (resources.water < 350) notEnough += "water, "
                if (resources.milk < 75) notEnough += "milk, "
                if (resources.coffeeBeans < 20) notEnough += "coffee beans, "
                if (resources.disposableCups < 1) notEnough += "disposable cups, "
                if (resources.water >= 350 && resources.milk >= 75 && resources.coffeeBeans >= 20 && resources.disposableCups >= 1) {

                    resources = Resources(
                        resources.water - 350,
                        resources.milk - 75,
                        resources.coffeeBeans - 20,
                        resources.disposableCups - 1,
                        resources.money + 7
                    )
                    return "I have enough resources, making you a coffee!"
                }
            }
            "3", "cappuccino" -> {
                if (resources.water < 200) notEnough += "water, "
                if (resources.milk < 100) notEnough += "milk, "
                if (resources.coffeeBeans < 12) notEnough += "coffee beans, "
                if (resources.disposableCups < 1) notEnough += "disposable cups, "
                if (resources.water >= 200 && resources.milk >= 100 && resources.coffeeBeans >= 12 && resources.disposableCups >= 1) {

                    resources = Resources(
                        resources.water - 200,
                        resources.milk - 100,
                        resources.coffeeBeans - 12,
                        resources.disposableCups - 1,
                        resources.money + 6
                    )
                    return "I have enough resources, making you a coffee!"
                }
            }
            "back" -> return ""
        }
        return "Sorry, not enough ${notEnough.dropLast(2)}!"
    }

    fun fill(addResources: Resources) {
        resources = Resources(
            resources.water + addResources.water,
            resources.milk + addResources.milk,
            resources.coffeeBeans + addResources.coffeeBeans,
            resources.disposableCups + addResources.disposableCups
        )
    }

    fun take(): String {
        val moneyTaken = resources.money
        val updatedResources = resources.copy(money = 0)
        resources = updatedResources
        return "I gave you $moneyTaken"
    }
}
