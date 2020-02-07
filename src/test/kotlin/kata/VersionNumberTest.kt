package kata

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

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
}
