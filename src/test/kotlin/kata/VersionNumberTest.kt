package kata

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.stream.Stream

class VersionNumberTest {

    @Test
    fun `Returns something`() {
        val version = VersionNumber.from("1.2.3")

        assertNotNull(version)
    }

    @Test
    fun `Test actual parsing`() {
        val version = VersionNumber.from("1.2.3")
        assertEquals(version.major, 1)
        assertEquals(version.minor, 2)
        assertEquals(version.patch, 3)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1.2.3", "3.2.1", "1.2.3-alpha", "3.2.1-beta"]) // six numbers
    fun `Test multiple versions`(str: String) {
        val version = VersionNumber.from(str)
        val elements = str.split(".", "-")

        assertEquals(version.major, elements[0].toInt())
        assertEquals(version.minor, elements[1].toInt())
        assertEquals(version.patch, elements[2].toInt())
        if (elements.count() > 3) {
            assertEquals(version.preRelease, elements[3])
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1.2.3", "3.2.1", "1.2.3+1"]) // six numbers
    fun `Test build info`(str: String) {
        val version = VersionNumber.from(str)
        val elements = str.split(".", "+")
        println(elements)
        assertEquals(version.major, elements[0].toInt())
        assertEquals(version.minor, elements[1].toInt())
        assertEquals(version.patch, elements[2].toInt())
        if (elements.count() > 3) {
            assertEquals(version.buildInfo, elements[3])
        }
    }

    @ParameterizedTest(name = "{index} - Parsing of {0}")
    @ValueSource(strings = ["1.2.3", "3.2.1", "1.2.3-alpha.1"]) // six numbers
    fun `Test pre release and build info`(str: String) {
        val version = VersionNumber.from(str)
        val elements = str.split(".", "-", "+")
        println(elements)
        assertEquals(version.major, elements[0].toInt())
        assertEquals(version.minor, elements[1].toInt())
        assertEquals(version.patch, elements[2].toInt())
        if (elements.count() > 4) {
            assertEquals(version.preRelease, elements[3])
            assertEquals(version.buildInfo, elements[4])
        }
    }

    @Test
    fun `Equals is the shit`() {
        val parsedVersion = VersionNumber.from("1.2.3")

        val expectedVersion = VersionNumber(
                major = 1,
                minor = 2,
                patch = 3
        )

        assertEquals(expectedVersion, parsedVersion)
    }

    @Test
    @ParameterizedTest(name = "{0}")
    @MethodSource("addCases")
    fun add(case : AddTest) {
        case.runTest()
    }


    companion object {

        @JvmStatic
        fun addCases() : Stream<AddTest> {
            return Stream.of(
                    AddTest(1, 1, 2),
                    AddTest(2, 2, 4)
            )
        }

    }



    data class AddTest(val a: Int, val b: Int, val expectedSum: Int) {

        fun runTest() {
            println(toString())
            assertEquals(expectedSum, a + b)
        }

        override fun toString(): String {
            return "Expecting: $a + $b = $expectedSum"
        }
    }

}
