package test;


import org.hamcrest.CoreMatchers
import org.junit.Test
import static hamcrest.MyMatchers.*
import static my.bank.Account.account
import static org.hamcrest.CoreMatchers.instanceOf
import static org.junit.Assert.*

/**
 * @author Mathieu Carbou (mathieu.carbou@gmail.com)
 */
class Test_Adv_1 {

    @Test
    void hamcrest_matchers() {
        assertEquals 0, account("4540-123-CARM").build().amount()

        assertThat account("4540-123-CARM").build(), has(amount(0))

        assertThat account("4540-123-CARM").build(), has(amount(1))
    }

    @Test
    void exceptions_matchers() {
        try {
            account("4540-123-CARM").withAmmount(-1)
            fail('must throw java.lang.IllegalArgumentException: Ammount must be positive')
        } catch (Exception e) {
            assertThat e, CoreMatchers.is(instanceOf(IllegalArgumentException))
            assertThat e, has(message('Ammount must be positive'))
        }
    }

    @Test
    void exceptions_matchers_2() {
        assertThat({account("4540-123-CARM").withAmmount(-1)}, thrown(IllegalArgumentException).withMessage('Ammount must be positive'))
        assertThat({account("4540-123-CARM").withAmmount(0)}, thrown(IllegalArgumentException).withMessage('Ammount must be positive'))
    }

}
