package test;


import org.junit.Test

/**
 * @author Mathieu Carbou (mathieu.carbou@gmail.com)
 */
class Test_Adv_4_1 {

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
