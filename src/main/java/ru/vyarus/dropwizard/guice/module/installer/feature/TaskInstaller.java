package ru.vyarus.dropwizard.guice.module.installer.feature;

import io.dropwizard.servlets.tasks.Task;
import io.dropwizard.setup.Environment;
import ru.vyarus.dropwizard.guice.module.installer.FeatureInstaller;
import ru.vyarus.dropwizard.guice.module.installer.util.FeatureUtils;

/**
 * Dropwizard tasks installer.
 * Looks for classes extending {@code io.dropwizard.servlets.tasks.Task} and register in environment.
 */
public class TaskInstaller implements FeatureInstaller<Task> {

    @Override
    public boolean matches(final Class<?> type) {
        return FeatureUtils.is(type, Task.class);
    }

    @Override
    public void install(final Environment environment, final Task instance) {
        environment.admin().addTask(instance);
    }
}
