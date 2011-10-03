package test;


import org.junit.Test
import static com.mycila.junit.matchers.ExceptionMatchers.*
import static hamcrest.MyMatchers.amount
import static hamcrest.MyMatchers.has
import static my.bank.Account.account
import static org.hamcrest.Matchers.instanceOf
import static org.junit.Assert.*

/**
 * @author Mathieu Carbou (mathieu.carbou@gmail.com)
 */
class Test_Adv_1 {

    @Test
    void hamcrest_matchers() {
        assertEquals 0, account("4540-123-CARM").build().amount()

        assertThat "default account's amount", account("4540-123-CARM").build(), is(amount(0))

        assertThat "default account's amount", account("4540-123-CARM").build(), is(amount(1))
    }

    @Test
    void exceptions_matchers() {
        try {
            account("4540-123-CARM").withAmmount(-1)
            fail('must throw java.lang.IllegalArgumentException: Amount must be positive')
        } catch (Exception e) {
            assertThat e, is(instanceOf(IllegalArgumentException))
            assertThat e, has(message('Amount must be positive'))
        }
    }

    @Test
    void exceptions_matchers_2() {
        assertThat(expression {account("4540-123-CARM").withAmmount(-1)}, thrown(IllegalArgumentException).withMessage('Amount must be positive'))

        assertThat(expression {account("4540-123-CARM").withAmmount(0)}, thrown(IllegalArgumentException).withMessage('Amount must be positive'))
    }

}
