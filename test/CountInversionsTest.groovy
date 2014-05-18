/**
 * Created by thgr on 09.05.2014.
 */
class CountInversionsTest extends GroovyTestCase {
    def countInversion = new CountInversions()

    void testCountSimple() {
        File file = numberFile("simple.txt")

        def (inv, sorted) = countInversion.count(file)
        assert [1, 2, 3, 4, 5, 6] == sorted
        assert inv == 3
    }

    private File numberFile(String fileName) {
        def file = new File("resources", fileName)
        assert file.exists()
        file
    }

    void testCountFinal() {
        File file = numberFile("IntegerArray.txt")

        def (inv, sorted) = countInversion.count(file)
        println sorted
        assert sorted.size() == 100000
        assert inv == 2407905288
    }
}
