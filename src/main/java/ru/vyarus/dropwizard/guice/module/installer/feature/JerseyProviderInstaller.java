package ru.vyarus.dropwizard.guice.module.installer.feature;

import io.dropwizard.setup.Environment;
import ru.vyarus.dropwizard.guice.module.installer.FeatureInstaller;
import ru.vyarus.dropwizard.guice.module.installer.util.FeatureUtils;

import javax.ws.rs.ext.Provider;

/**
 * Jersey provider installer.
 * Looks for classes annotated with {@code @javax.ws.rs.ext.Provider} and register in environment.
 */
public class JerseyProviderInstaller implements FeatureInstaller<Object> {

    @Override
    public boolean matches(final Class<?> type) {
        return FeatureUtils.hasAnnotation(type, Provider.class);
    }

    @Override
    public void install(final Environment environment, final Object instance) {
        environment.jersey().register(instance);
    }
}
