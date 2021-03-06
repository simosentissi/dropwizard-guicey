package ru.vyarus.dropwizard.guice.support

import io.dropwizard.Application
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment
import ru.vyarus.dropwizard.guice.GuiceBundle

/**
 * Example of automatic configuration: installers, beans and commands searched automatically.
 * @author Vyacheslav Rusakov 
 * @since 01.09.2014
 */
class AutoScanApplication extends Application<TestConfiguration> {

    public static void main(String[] args) {
        new AutoScanApplication().run(args)
    }

    @Override
    void initialize(Bootstrap<TestConfiguration> bootstrap) {
        bootstrap.addBundle(GuiceBundle.<TestConfiguration> builder()
                .enableAutoConfig("ru.vyarus.dropwizard.guice.support.feature")
                .searchCommands(true)
                .build()
        );
    }

    @Override
    void run(TestConfiguration configuration, Environment environment) throws Exception {
    }
}
