// Оголошення інтерфейсу Queue
interface Queue<T : Any> {
    // Додає елемент до черги та повертає true, якщо операція успішна
    fun enqueue(element: T): Boolean

    // Видаляє та повертає перший елемент черги
    fun dequeue(): T?

    // Властивість, що повертає кількість елементів у черзі
    val count: Int
        get

    // Властивість, що повертає true, якщо черга порожня
    val isEmpty: Boolean
        get() = count == 0

    // Повертає перший елемент у черзі без його видалення
    fun peek(): T?
}
