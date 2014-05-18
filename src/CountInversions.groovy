/**
 * Created by thgr on 09.05.2014.
 */
class CountInversions {
    def count(File file) {
        def numbers = file.readLines().collect {it.toLong()}
        sortAndCount(numbers)
    }

    def sortAndCount(List<Long> numbers) {
        //println "sourt and count $numbers"
        if (numbers.size() == 1) {
            return [0L, numbers]
        }
        def count = numbers.size().intdiv(2)
        def (x, firstHalf) = sortAndCount(numbers[0..<count])
        //println "first half $firstHalf"
        def (y, secondHalf) = sortAndCount(numbers[count..-1])
        //println "second half $secondHalf"
        def (z, sorted) = mergeCount(firstHalf, secondHalf)
        [x + y + z, sorted]
    }

    def mergeCount(List<Long> first, List<Long> second) {
        def i = 0
        def j = 0
        long countInversions = 0
        def totalSize = first.size() + second.size()
        def result = new ArrayList(totalSize)
        //println "$first $second"
        totalSize.times {
            //println "$i $j"
            if (first[i] && first[i] < second[j]) {
                result << first[i++]
            } else if (second[j]) {
                result << second[j++]
                countInversions += first.size() - i
            } else {
                result << first[i++]
            }
        }
        //println "merge $first and $second to $result"
        [countInversions, result]
    }
}
