package example1.service.impl

import example1.service.SortStrategy

class QuickSortStrategyImpl : SortStrategy {
    override suspend fun sort(list: MutableList<Int>) = quickSort(list)

    fun quickSort(list: MutableList<Int>): List<Int> {
        if (list.size < 2) return list
        val pivot = list[list.size / 2]
        val equal = list.filter { it == pivot }
        val less = list.filter { it < pivot }
        val greater = list.filter { it > pivot }
        return quickSort(less.toMutableList()) + equal + quickSort(greater.toMutableList())
    }
}