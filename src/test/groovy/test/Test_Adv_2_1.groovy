package test;


import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement
import org.junit.*

/**
 * @author Mathieu Carbou (mathieu.carbou@gmail.com)
 */
class Test_Adv_2_1 {

    @ClassRule public static TestRule classLevel = {Statement base, Description description ->
        printMe('@ClassRule - wrapping')
        return {
            printMe("@ClassRule - before class: ${description.className}")
            base.evaluate()
            printMe("@ClassRule - after class: ${description.className}")
        } as Statement
    } as TestRule

    @Rule public static TestRule testLevel = {Statement base, Description description ->
        printMe('@Rule - wrapping')
        return {
            printMe("@Rule - before test ${description.methodName}")
            base.evaluate()
            printMe("@Rule - after test ${description.methodName}")
        } as Statement
    } as TestRule

    @BeforeClass static void beforeClass() { printMe() }
    @AfterClass static void afterClass() { printMe() }
    @Before void beforeTest() { printMe() }
    @After void afterTest() { printMe() }
    @Test void test_1() { printMe() }
    @Test void test_2() { printMe() }

    static void printMe(where = null) { println where ?: new Throwable().stackTrace.with {StackTraceElement[] els -> els.find({StackTraceElement el -> el?.methodName != 'printMe' && el?.className?.endsWith('Test_Adv_2_1')})?.methodName} }
}
