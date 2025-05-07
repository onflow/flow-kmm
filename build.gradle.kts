buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven {
            url = uri("https://oss.sonatype.org/content/repositories/snapshots")
        }
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:2.0.21")
        // downgraded to 4.2.2 from 7.2.1 to support    intellij IDEA development
        classpath("com.android.tools.build:gradle:8.5.0")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven { setUrl("https://jitpack.io") }
    }

    group = "org.onflow.flow"
    val defaultVersion = "0.0.5"
    version = System.getenv("GITHUB_REF")?.split('/')?.last() ?: defaultVersion
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}