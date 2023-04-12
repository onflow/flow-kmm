buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.0")
        // downgraded to 4.2.2 from 7.2.1 to support    intellij IDEA development
        classpath("com.android.tools.build:gradle:4.2.2")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven { setUrl("https://jitpack.io") }
    }

    group = "org.onflow.flow"
    val defaultVersion = "0.0.1"
    version = System.getenv("GITHUB_REF")?.split('/')?.last() ?: defaultVersion
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}