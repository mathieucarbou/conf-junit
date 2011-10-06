package test;


import org.junit.Test
import org.junit.experimental.categories.Category

/**
 * @author Mathieu Carbou (mathieu.carbou@gmail.com)
 */
@Category([UnitTests, DBTests])
class CTest {
    @Test @Category(SystemTests) void test_1() {}
    @Test void test_2() {}
}
