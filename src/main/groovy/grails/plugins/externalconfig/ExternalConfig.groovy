package grails.plugins.externalconfig

import org.grails.io.support.ClassPathResource
import org.grails.io.support.Resource
import org.springframework.context.EnvironmentAware
import org.springframework.core.env.Environment
import org.springframework.core.env.MapPropertySource

trait ExternalConfig implements EnvironmentAware {
    /**
     * Set the {@code Environment} that this object runs in.
     */
    @Override
    void setEnvironment(Environment environment) {
        List locations = environment.getProperty('grails.config.locations', ArrayList) as List

        if (locations) {
            locations.reverse().each { location ->
                Resource resource = new ClassPathResource(location.toString())
                def config = new ConfigSlurper(grails.util.Environment.current.name).parse(resource.URL)
                environment.propertySources.addFirst(new MapPropertySource(config.toString(), config))
            }
        }

    }
}
