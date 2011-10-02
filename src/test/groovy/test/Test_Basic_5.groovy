package test;


import org.junit.Test
import static org.junit.Assert.*

/**
 * @author Mathieu Carbou (mathieu.carbou@gmail.com)
 */
class Test_Basic_5 {

    @Test
    void some_assertions() {
        assertArrayEquals "numbers", [1, 2, 3] as int[], [1, 2, 3] as int[]
    }

    @Test
    void decimal_assertions() {
        System.out.println(1 / 3 * 3);
        assertTrue '1 / 3 * 3 == 1', 1 / 3 * 3 == 1
    }

    @Test
    void decimal_assertions_2() {
        System.out.println(1 / 3 * 3);
        assertEquals '1 / 3 * 3 == 1', 1, 1 /3 * 3, 0.0001
    }

}
