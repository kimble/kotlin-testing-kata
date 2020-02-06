package kata

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CalculatorTest {

    @Test
    fun sanity_check() {
        assertEquals(4, Calculator().add(2, 2), "Oh my god! Arithmetic is broken!")
    }

}