package test;


import org.junit.runner.RunWith
import runner.MyRunner
import org.junit.*

/**
 * @author Mathieu Carbou (mathieu.carbou@gmail.com)
 */
@RunWith(MyRunner)
class Test_Adv_3_3 {

    @BeforeClass static void beforeClass() { printMe() }
    @AfterClass static void afterClass() { printMe() }
    @Before void beforeTest() { printMe() }
    @After void afterTest() { printMe() }
    @Test void test_1() { printMe() }
    @Test void test_2() { printMe() }

    static void printMe(where = null) { println where ?: new Throwable().stackTrace.with {StackTraceElement[] els -> els.find({StackTraceElement el -> el?.methodName != 'printMe' && el?.className?.endsWith('Test_Adv_3_3')})?.methodName} }
}
