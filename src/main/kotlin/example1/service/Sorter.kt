package example1.service

class Sorter(private val strategy: SortStrategy) {
    suspend fun sorter(list: MutableList<Int>): List<Int> = strategy.sort(list)
}