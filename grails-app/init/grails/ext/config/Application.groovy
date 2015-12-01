package grails.ext.config
import grails.boot.GrailsApp
import grails.boot.config.GrailsAutoConfiguration
import org.grails.io.support.ClassPathResource
import org.grails.io.support.Resource
import org.springframework.context.EnvironmentAware
import org.springframework.core.env.Environment

class Application extends GrailsAutoConfiguration implements EnvironmentAware {
    static void main(String[] args) {
        GrailsApp.run(Application, args)
    }

    /**
     * Set the {@code Environment} that this object runs in.
     */
    @Override
    void setEnvironment(Environment environment) {
        println environment

        List locations = environment.getProperty('grails.config.locations', ArrayList) as List

        if(locations) {
            println locations

            locations.reverse().each { location ->
                    Resource resource = new ClassPathResource(location.toString())
                    println resource.file

            }
        }

    }
}