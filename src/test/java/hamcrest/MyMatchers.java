package hamcrest;

import my.bank.Account;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.Is;

/**
 * @author Mathieu Carbou (mathieu.carbou@gmail.com)
 */
public final class MyMatchers {

    private MyMatchers() {
    }

    public static <T> Matcher<T> has(final Matcher<T> matcher) {
        return new Is<T>(matcher) {
            @Override
            public void describeTo(Description description) {
                description.appendText("has ").appendDescriptionOf(matcher);
            }
        };
    }

    public static Matcher<Account> amount(final int amount) {
        return new TypeSafeMatcher<Account>() {
            @Override
            protected boolean matchesSafely(Account item) {
                return item.amount() == amount;
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("amount ").appendValue(amount);
            }
        };
    }
}
