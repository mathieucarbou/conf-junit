package test;


import org.junit.Test
import static my.bank.Account.account
import static org.junit.Assert.assertEquals

/**
 * @author Mathieu Carbou (mathieu.carbou@gmail.com)
 */
class Test_Basic_1 {

    @Test
    void account_creation_default() {
        assertEquals "amount", 0, account("4540-123-CARM").build().amount()
    }

    @Test
    void account_creation_fail() {
        account("4540-123-CARM").withAmmount(-5)
    }

    @Test(expected = IllegalArgumentException)
    void account_creation_fail_checked() {
        account("4540-123-CARM").withAmmount(-5)
    }

    @Test(timeout = 1000L)
    void too_long_test() {
        sleep 1500
    }

}
