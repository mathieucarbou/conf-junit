package hamcrest;

import groovy.lang.Closure;
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

    public static Matcher<Throwable> message(final String message) {
        return new TypeSafeMatcher<Throwable>() {
            @Override
            protected boolean matchesSafely(Throwable item) {
                return message == null && item.getMessage() == null || message != null && message.equals(item.getMessage());
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("message ").appendValue(message);
            }
        };
    }

    public static Thrown thrown(Class<? extends Throwable> exceptionClass) {
        return new Thrown(exceptionClass);
    }

    public static final class Thrown extends TypeSafeMatcher<Closure<?>> {
        private final Class<? extends Throwable> exceptionClass;
        private String message;

        private Thrown(Class<? extends Throwable> exceptionClass) {
            this.exceptionClass = exceptionClass;
        }

        public Matcher<Closure<?>> withMessage(String msg) {
            this.message = msg;
            return this;
        }

        @Override
        protected boolean matchesSafely(Closure<?> item) {
            try {
                item.call();
                return false;
            } catch (Throwable e) {
                return exceptionClass.isInstance(e) && (message == null || message.equals(e.getMessage()));
            }
        }

        @Override
        public void describeTo(Description description) {
            description.appendText("expression throwing ").appendValue(exceptionClass.getName());
            if (message != null) {
                description.appendText(" with message '").appendValue(message).appendText("'");
            }
        }
    }
}
