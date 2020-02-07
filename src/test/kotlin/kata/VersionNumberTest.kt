package kata

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

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
    @ValueSource(strings = ["1.2.3", "3.2.1", "1.2.3-alpha"]) // six numbers
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


}
