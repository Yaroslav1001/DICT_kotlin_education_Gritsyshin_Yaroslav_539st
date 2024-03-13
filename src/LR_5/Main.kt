package LR_5

import ArrayListQueue

fun main() {
    // Створення черги типу Int
    val queue = ArrayListQueue<Int>()

    // Додавання елементів до черги
    queue.enqueue(1)
    queue.enqueue(2)
    queue.enqueue(3)

    // Виведення першого елемента черги без його видалення
    println("Перший елемент черги: ${queue.peek()}")

    // Видалення та виведення всіх елементів черги
    println("Елементи черги:")
    while (!queue.isEmpty) {
        val element = queue.dequeue()
        println(element)
    }

    // Перевірка, чи черга порожня
    if (queue.isEmpty) {
        println("Черга порожня")
    } else {
        println("Черга не порожня")
    }
}