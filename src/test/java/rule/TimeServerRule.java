package rule;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import tools.TimeServer;

/**
 * @author Mathieu Carbou (mathieu.carbou@gmail.com)
 */
public final class TimeServerRule implements TestRule{
    @Override
    public Statement apply(final Statement base, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                TimeServer timeServer = new TimeServer();
                timeServer.start();
                try {
                    base.evaluate();
                } finally {
                    timeServer.stop();
                }
            }
        };
    }
}
