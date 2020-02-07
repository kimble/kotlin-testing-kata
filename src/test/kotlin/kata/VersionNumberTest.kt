package kata

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class VersionNumberTest {

    @Test
    fun `Returns something`() {
        val version = VersionNumber.from("1.2.3")

        assertNotNull(version)
    }

}