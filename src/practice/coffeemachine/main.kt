package practice.coffeemachine

fun main(){
    print("""
        
        Starting to make a coffee in NIX office
        Grinding coffee beans
        Boiling water
        Mixing boiled water with crushed coffee beans
        Pouring coffee into the cup
        Pouring some milk into the cup
        Coffee is ready! Go to work!
        
    """.trimIndent())

    println("Write how many cups of coffee you will need:")
    print("> ")
    val cups = readln().toInt() ?:0
    val water = 0
    val milk = 0
    val coffee = 0

    println("""
        For $cups cups of coffee you will need:
        ${200 * cups} ml of water
        ${50 * cups} ml of milk
        ${15 * cups} g of coffee beans
        """.trimIndent())
}