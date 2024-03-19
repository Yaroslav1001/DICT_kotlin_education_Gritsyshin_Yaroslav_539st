package practice.coffeemachine

import kotlin.math.min

fun main(){

    println("Write how many ml of water the coffee machine has:")
    print("> ")
    val water = readln().toInt()

    println("Write how many ml of milk the coffee machine has:")
    print("> ")
    val milk = readln().toInt()

    println("Write how many grams of coffee beans the coffee machine has:")
    print("> ")
    val coffee = readln().toInt()

    println("Write how many cups of coffee you will need:")
    print("> ")
    val cups = readln().toInt()

    val cupsPossible = minOf(water / 200, milk / 50, coffee / 15)

    if (cupsPossible >= cups) {
        if (cupsPossible == cups) {
            println("Yes, I can make that amount of coffee")
        } else {
            print("Yes, I can make that amount of coffee (and even ${cupsPossible - cups} more than that)")
        }
    } else {
        println("No, I can make only $cupsPossible cups of coffee")
    }
}