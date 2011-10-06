package test;


import com.mycila.junit.concurrent.ConcurrentSuiteRunner
import org.junit.runner.RunWith
import org.junit.runners.Suite.SuiteClasses
import org.junit.runner.JUnitCore

/**
 * @author Mathieu Carbou (mathieu.carbou@gmail.com)
 */
@RunWith(ConcurrentSuiteRunner)
@SuiteClasses([LongTest1, LongTest2])
class Test_Adv_3_5 {

    public static void main(String[] args) {
        JUnitCore.main(Test_Adv_3_5.class.name)
    }
    
}
