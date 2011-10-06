package test;


import com.mycila.junit.rule.Duration

import com.mycila.junit.rule.Times
import org.junit.ClassRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.JUnitCore
import com.mycila.junit.rule.TestRepeater

/**
 * @author Mathieu Carbou (mathieu.carbou@gmail.com)
 */
@Times(2)
class Test_Adv_2_3 {

    @ClassRule public static Duration classDuration = new Duration()
    @Rule public Duration testDuration = new Duration()
    
    @ClassRule public static TestRepeater classExecution = new TestRepeater()
    @Rule public TestRepeater testExecution = new TestRepeater()

    @Test @Times(3)
    void test_execution_in_parallel_3_times() {
        println "[${Integer.toHexString(hashCode())}] [${Thread.currentThread().name}] parallel"
        sleep 1000
    }

    @Test @Times(value = 2, concurrent = false)
    void test_execution_consecutive_2_times() {
        println "[${Integer.toHexString(hashCode())}] [${Thread.currentThread().name}] sequential"
        sleep 1000
    }

    // runs junit directly
    public static void main(String[] args) {
        JUnitCore.main(Test_Adv_2_3.class.name)
    }
}
