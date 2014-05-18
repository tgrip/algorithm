/**
 * Created by thgr on 18.05.2014.
 */
class Ouicksort {
    def sort(File file) {
        def numbers = file.readLines().collect {it.toLong()}
        quicksort(numbers)
        numbers
    }

    private void quicksort(List numbers) {
        println "quicksort $numbers"
        if (numbers.size() == 1) {
            return
        }
        def pivot = choosePivot(numbers)
        Collections.swap(numbers, 0, pivot)
        def pivotPos = partition(numbers, 0, numbers.size() - 1)
        println "pivot pos $pivotPos"
        quicksort(numbers[0..pivotPos-1])
        quicksort(numbers[pivotPos+1..numbers.size() - 1])
    }

    int partition(List list, int left, int right) {
        long p = list[0]
        def i = left + 1
        (i+1..right).each { j ->
            if (list[j] < p) {
                Collections.swap(list, j, i++)
            }
        }
        def pivotPos = i - 1
        Collections.swap(list, 0, pivotPos)
        pivotPos
    }


    int choosePivot(List list) {
        0
    }
}
