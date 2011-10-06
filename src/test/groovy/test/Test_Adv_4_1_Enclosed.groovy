package test;


import org.junit.Test
import org.junit.experimental.runners.Enclosed
import org.junit.runner.RunWith

/**
 * @author Mathieu Carbou (mathieu.carbou@gmail.com)
 */
@RunWith(Enclosed)
class Test_Adv_4_1_Enclosed {

    @Test void test1() {}
    @Test void test2() {}

    public static class InnerClass1 {
        @Test void test3() {}
        @Test void test4() {}
    }

    public static class InnerClass2 {
        @Test void test5() {}
        @Test void test6() {}
    }
}
