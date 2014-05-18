/**
 * Created by thgr on 18.05.2014.
 */
class QuicksortTest extends GroovyTestCase {
    void testQuicksortSimple() {
        def quicksort = new Ouicksort()

        def file = new File("resources", "simpleQs.txt")
        assert file.exists()

        def sorted = quicksort.sort(file)
        println sorted
    }
}
