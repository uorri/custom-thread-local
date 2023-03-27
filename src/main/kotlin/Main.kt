fun main() {
    val threadLocal = CustomThreadLocal<String>()
    threadLocal.set("Aloha")
    println("Thread 1: ${threadLocal.get()}")

    Thread {
        threadLocal.set("Hola!")
        println("Thread 2: ${threadLocal.get()}")
        threadLocal.remove()
        println("Thread 2: ${threadLocal.get()}")
    }.start()

    println("Thread 1: ${threadLocal.get()}")
}