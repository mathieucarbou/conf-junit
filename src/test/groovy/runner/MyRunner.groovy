package runner

import org.junit.runners.BlockJUnit4ClassRunner

class MyRunner extends BlockJUnit4ClassRunner {
    MyRunner(Class<?> klass) {
        super(klass)
    }
}
