plugins {
    kotlin("jvm") version "1.6.0"
    id("se.thinkcode.cucumber-runner") version "0.0.8"
}


repositories {
    mavenCentral()
}

dependencies {
    val restAssuredVersion = "4.4.0"
    val cucumberVersion = "6.10.3"

    testImplementation(
        group = "io.rest-assured",
        name = "kotlin-extensions",
        version = restAssuredVersion
    )
    testImplementation(
        group = "io.cucumber",
        name = "cucumber-junit",
        version = cucumberVersion
    )
    testImplementation(
        group = "io.cucumber",
        name = "cucumber-java",
        version = cucumberVersion
    )
    testImplementation(
        group = "io.cucumber",
        name = "cucumber-core",
        version = cucumberVersion
    )
    testImplementation(
        group = "net.masterthought",
        name = "cucumber-reporting",
        version = "5.5.2"
    )
    testImplementation(
        group = "com.google.code.gson",
        name = "gson",
        version = "2.8.6"
    )
}
