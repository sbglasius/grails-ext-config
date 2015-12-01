package grails.ext.config

import grails.boot.GrailsApp
import grails.boot.config.GrailsAutoConfiguration
import grails.plugins.externalconfig.ExternalConfig

class Application extends GrailsAutoConfiguration implements ExternalConfig {
    static void main(String[] args) {
        GrailsApp.run(Application, args)
    }
}