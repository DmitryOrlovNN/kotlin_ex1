package example1.service.impl

import example1.service.SortStrategy

class BubbleSortStrategyImpl : SortStrategy {
    override suspend fun sort(list: MutableList<Int>) = bubbleSort(list)

    private fun bubbleSort(list: MutableList<Int>): List<Int> {
        val n = list.size
        for (i in 0 until n-1) {
            for (j in 0 until n-i-1) {
                if (list[j] > list[j+1]) {
                    // swap arr[j+1] and arr[j]
                    val temp = list[j]
                    list[j] = list[j+1]
                    list[j+1] = temp
                }
            }
        }
        return list
    }
}