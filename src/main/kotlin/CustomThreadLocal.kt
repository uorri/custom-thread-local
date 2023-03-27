import java.util.WeakHashMap
import java.util.concurrent.locks.ReentrantReadWriteLock
import kotlin.concurrent.withLock

class CustomThreadLocal<T> {
    private val threadLocalMap = WeakHashMap<Thread, T>()
    private val lock = ReentrantReadWriteLock()
    private val readLock = lock.readLock()
    private val writeLock = lock.writeLock()
    fun get() = readLock.withLock { threadLocalMap[Thread.currentThread()] }
    fun set(value: T) = writeLock.withLock { threadLocalMap[Thread.currentThread()] = value }
    fun remove() = writeLock.withLock { threadLocalMap.remove(Thread.currentThread()) }
}
