package runner

import org.junit.runners.BlockJUnit4ClassRunner
import org.junit.runners.model.RunnerScheduler

class MyRunner extends BlockJUnit4ClassRunner {

    MyRunner(Class<?> klass) {
        super(klass)

        setScheduler([
            schedule: {Runnable child ->
                println 'Scheduling child...'
                child.run()
            },
            finished: {
                println 'Scheduling finished !'
            }
        ] as RunnerScheduler)

    }

    @Override
    protected Object createTest() {
        println 'Creating test instance...'
        return getTestClass().onlyConstructor.newInstance()
    }

}
