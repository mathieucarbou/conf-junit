package test;


import tools.TimeServer
import org.junit.*

/**
 * @author Mathieu Carbou (mathieu.carbou@gmail.com)
 */
class Test_Basic_2 {

    //-----------------------------------------------------

    static { println '[CLASS RESOLVED]' }
    static timeServer = new TimeServer()

    @BeforeClass
    static void before_instanciation() {
        println '[@BeforeClass]'
        timeServer.start()
    }

    @AfterClass
    static void after_instanciation() {
        println '[@AfterClass]'
        timeServer.stop()
    }

    //-----------------------------------------------------

    { println '[CLASS INSTANCIATION] ' + Integer.toHexString(hashCode()) }
    long time;

    @Before
    void before_each_test() {
        println '[@Before]'
        time = timeServer.now()
    }

    @After
    void after_each_test() { println '[@After]' }

    //-----------------------------------------------------

    @Test
    void test_1() { println "[@Test] TEST 1 => TIME = ${time}" }

    @Test
    void test_2() { println "[@Test] TEST 2 => TIME = ${time}" }

}
