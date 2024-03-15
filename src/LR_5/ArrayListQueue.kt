// Імпортуємо необхідний клас для роботи зі списками
import java.util.ArrayList

// Оголошення класу, який реалізує інтерфейс Queue
class ArrayListQueue<T : Any> : Queue<T> {
    // Приватне поле, яке представляє чергу
    private val elements = ArrayList<T>()

    // Реалізація методу enqueue
    override fun enqueue(element: T): Boolean {
        // Додаємо елемент у кінець черги за допомогою методу add
        return elements.add(element)
    }

    // Реалізація методу dequeue
    override fun dequeue(): T? {
        // Перевіряємо, чи черга порожня
        return if (isEmpty) {
            // Якщо так, повертаємо null
            null
        } else {
            // Інакше видаляємо та повертаємо перший елемент черги
            elements.removeAt(0)
        }
    }

    // Реалізація властивості count
    override val count: Int
        get() = elements.size

    // Реалізація властивості isEmpty
    override val isEmpty: Boolean
        get() = elements.isEmpty()

    // Реалізація методу peek
    override fun peek(): T? {
        // Повертаємо перший елемент у черзі без його видалення
        return elements.firstOrNull()
    }
}
