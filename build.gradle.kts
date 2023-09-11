plugins {
    kotlin("jvm") version "1.9.10"
    application
}

group = "andriesfc.edutalk.adapter-pattern"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.github.ajalt:clikt:2.8.0")
    testImplementation("io.kotest:kotest-runner-junit5:5.7.2")
}

tasks.withType<Test>().configureEach { useJUnitPlatform() }


val sourcesJar by tasks.registering(Jar::class) {
    from(sourceSets.main.get().allSource)
}


artifacts {
    archives(sourcesJar)
}


kotlin {
    jvmToolchain(20)
}

application {
    mainClass.set("headfirst.adapterpattern.MainKt")
    applicationName = "hdp-adapter-pattern"
}



