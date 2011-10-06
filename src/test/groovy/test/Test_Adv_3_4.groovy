package test;


import org.junit.runner.RunWith
import runner.MyRunner
import org.junit.*
import com.mycila.junit.concurrent.ConcurrentJunitRunner
import com.mycila.junit.concurrent.Concurrency
import org.junit.runner.JUnitCore
import com.mycila.junit.rule.Duration

/**
 * @author Mathieu Carbou (mathieu.carbou@gmail.com)
 */
@RunWith(ConcurrentJunitRunner)
@Concurrency(8)
class Test_Adv_3_4 {

    @ClassRule public static Duration classDuration = new Duration()
    @Rule public Duration testDuration = new Duration()

    @Test void test_1() { printMe(); sleep 1000 }
    @Test void test_2() { printMe(); sleep 2000 }
    @Test void test_3() { printMe(); sleep 2000 }
    @Test void test_4() { printMe(); sleep 3000 }
    @Test void test_5() { printMe(); sleep 2000 }
    @Test void test_6() { printMe(); sleep 2000 }
    @Test void test_7() { printMe(); sleep 2000 }

    static void printMe(where = null) { println '[' +Thread.currentThread().name + '] ' + (where ?: new Throwable().stackTrace.with {StackTraceElement[] els -> els.find({StackTraceElement el -> el?.methodName != 'printMe' && el?.className?.endsWith('Test_Adv_3_4')})?.methodName}) }

    public static void main(String[] args) {
        JUnitCore.main(Test_Adv_3_4.class.name)
    }
}
