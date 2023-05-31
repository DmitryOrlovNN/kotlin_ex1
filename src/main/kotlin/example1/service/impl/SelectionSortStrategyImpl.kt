package example1.service.impl

import example1.service.SortStrategy

class SelectionSortStrategyImpl : SortStrategy {
    override suspend fun sort(list: MutableList<Int>) = selectionSort(list)

    fun selectionSort(list: MutableList<Int>): List<Int> {
        for (i in list.indices) {
            var min = i
            for (j in i + 1 until list.size) {
                if (list[j] < list[min]) {
                    min = j
                }
            }
            val temp = list[min]
            list[min] = list[i]
            list[i] = temp
        }
        return list
    }
}