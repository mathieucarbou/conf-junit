package test;


import org.junit.Test
import org.junit.experimental.categories.Category

/**
 * @author Mathieu Carbou (mathieu.carbou@gmail.com)
 */
class Btest {
    @Test @Category(SystemTests) void test_1() {sleep 2000}
    @Test @Category(UnitTests) void test_2() {}
}
