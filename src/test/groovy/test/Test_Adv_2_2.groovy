package test;


import com.mycila.junit.rule.Duration
import org.junit.ClassRule
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.junit.rules.Timeout
import rule.TimeServerRule

/**
 * @author Mathieu Carbou (mathieu.carbou@gmail.com)
 */
class Test_Adv_2_2 {

    @ClassRule public static Timeout classTimeout = new Timeout(2500)
    @ClassRule public static Duration classDuration = new Duration()
    @ClassRule public static TimeServerRule timeServer = new TimeServerRule()

    @Rule public Timeout testTimeout = new Timeout(1500)
    @Rule public Duration testDuration = new Duration()
    @Rule public ExpectedException exception = ExpectedException.none()

    @Test void a_test() {}

    @Test void test_exception() {
        exception.expect(NumberFormatException)
        exception.expectMessage('')
        Integer.parseInt('not an integer')
    }

    @Test void a_long_test() { sleep 1000 }
    @Test void another_long_test() { sleep 2000 }
}
