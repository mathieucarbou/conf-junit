package test;


import org.junit.experimental.theories.DataPoint
import org.junit.experimental.theories.DataPoints
import org.junit.experimental.theories.Theories
import org.junit.experimental.theories.Theory
import org.junit.runner.RunWith
import static org.junit.Assert.assertTrue

/**
 * @author Mathieu Carbou (mathieu.carbou@gmail.com)
 */
@RunWith(Theories)
class Test_Adv_4_3_Theories {

    @Theory
    void isPrime(long n) { println "isPrime: ${n}"; assertTrue BigInteger.valueOf(n).isProbablePrime(80); }

    @Theory
    void isPositive(long n) { println "isPositive: ${n}"; assertTrue n >= 0 }

    @DataPoint
    public static long n1 = 3

    @DataPoint
    public static long n() { return 5 }

    @DataPoints
    public static long[] n2 = [7, 11]

    @DataPoints
    public static long[] many() { return [7, 11, 13, 17, 19] }

}
