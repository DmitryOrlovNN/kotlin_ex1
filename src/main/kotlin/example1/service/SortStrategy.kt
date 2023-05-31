package example1.service

interface SortStrategy {
    suspend fun sort(list: MutableList<Int>): List<Int>
}