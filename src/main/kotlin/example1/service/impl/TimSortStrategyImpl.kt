package example1.service.impl

import example1.service.SortStrategy

class TimSortStrategyImpl : SortStrategy {
    override suspend fun sort(list: MutableList<Int>) = timSort(list)

    private fun timSort(list: MutableList<Int>): List<Int> {
        list.sort()
        return list
    }
}