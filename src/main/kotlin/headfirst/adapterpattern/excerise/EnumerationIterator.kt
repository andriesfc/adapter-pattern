package headfirst.adapterpattern.excerise

import java.util.*

class EnumerationIterator<E>(private val enum: Enumeration<E>) : Iterator<E> {
    override fun hasNext(): Boolean = enum.hasMoreElements()
    override fun next(): E = enum.nextElement()

    override fun equals(other: Any?): Boolean {
        return when {
            other === this -> true
            other !is EnumerationIterator<*> -> false
            else -> enum == other.enum
        }
    }
    override fun hashCode(): Int = Objects.hash(enum)
}

