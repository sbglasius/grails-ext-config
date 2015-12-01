
println "Reading some config"

some.config = "environment: any"

environments {
    development {
        some.config = "environment: development"
    }
}
