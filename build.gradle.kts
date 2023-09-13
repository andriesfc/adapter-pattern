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


sourceSets.main.configure {
    resources {
        srcDirs("src/main/kotlin")
        include("**/*.kt")
        exclude(
            "headfirst/adapterpattern/main.kt",
            "headfirst/adapterpattern/common/",
            "headfirst/adapterpattern/commandline/"
        )
    }
}

kotlin {
    jvmToolchain(20)
}

application {
    mainClass.set("headfirst.adapterpattern.MainKt")
    applicationName = "hdp-adapter-pattern"
}
