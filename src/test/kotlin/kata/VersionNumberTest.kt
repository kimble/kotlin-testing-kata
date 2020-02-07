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
    @ValueSource(strings = ["1.2.3", "3.2.1"]) // six numbers
    fun `Test multiple versions`(str: String) {
        val version = VersionNumber.from(str)
        assertEquals(version.major, str.split(".")[0].toInt())
        assertEquals(version.minor, str.split(".")[1].toInt())
        assertEquals(version.patch, str.split(".")[2].toInt())
    }
}
