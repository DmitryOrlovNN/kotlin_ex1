import example1.service.Sorter
import example1.service.impl.*
import kotlinx.coroutines.*
import kotlin.random.Random
import kotlin.system.measureTimeMillis


fun main() {
    val numbers = MutableList(200000) { Random.nextInt(0, 100000) }

    val sorterBubble = Sorter(BubbleSortStrategyImpl())
    val sorterMerge = Sorter(MergeSortStrategyImpl())
    val sorterQuick = Sorter(QuickSortStrategyImpl())
    val sorterSelection = Sorter(SelectionSortStrategyImpl())
    val timSortStrategy = Sorter(TimSortStrategyImpl())

    runBlocking {
        val sorters = listOf(
            Pair(sorterBubble, "Bubble"),
            Pair(sorterMerge, "Merge"),
            Pair(sorterQuick, "Quick"),
            Pair(sorterSelection, "Selection"),
            Pair(timSortStrategy, "TimSort (JVM Default)")
        )

        val jobs = mutableListOf<Job>()

        sorters.forEach { (sorter, name) ->
            val job = CoroutineScope(Dispatchers.Default).launch {
                val time = measureTimeMillis {
                    sorter.sorter(numbers.toMutableList())
                }
                println("$name sort time: $time ms")
            }
            jobs.add(job)
        }

        jobs.forEach { it.join() } // Wait for all jobs to complete.
    }

}