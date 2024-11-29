import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework
import java.lang.System.getenv

plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization") version "2.0.21"
    id("com.android.library")
    id("io.github.luca992.multiplatform-swiftpackage") version "2.0.5-arm64"
    id("maven-publish")
}

multiplatformSwiftPackage {
    swiftToolsVersion("5.3")
    targetPlatforms {
        iOS { v("13") }
    }
}

kotlin {

    jvmToolchain(17)

    android {
        publishLibraryVariants("release", "debug")
    }

    val xcf = XCFramework()
    ios {
        binaries {
            framework {
                baseName = "Flow"
                xcf.add(this)
            }
        }
    }

    val coroutineVersion = "1.9.0"
    val ktorVersion = "3.0.1"
    val kotlincrypto = "0.5.3"
    
    sourceSets {kotlin
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutineVersion") {
                    version {
                        strictly(coroutineVersion)
                    }
                }

                implementation("io.ktor:ktor-client-core:$ktorVersion")
                implementation("io.ktor:ktor-utils:$ktorVersion")
                implementation("io.ktor:ktor-client-logging:$ktorVersion")
                implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
                implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")

                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.3")
                implementation("com.ionspin.kotlin:bignum:0.3.10")
                implementation("com.ionspin.kotlin:bignum-serialization-kotlinx:0.3.10")
                implementation("com.ionspin.kotlin:bignum:0.3.10-SNAPSHOT")

                implementation("org.kotlincrypto.hash:sha2:$kotlincrypto")
                implementation("org.kotlincrypto.hash:sha3:$kotlincrypto")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-okhttp:$ktorVersion")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutineVersion")
            }
        }
        val iosMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-darwin:$ktorVersion")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-native:1.3.8")
            }
        }
        val iosTest by getting
    }
}

android {
    namespace = "com.flow.flowKMM"
    compileSdk = 32
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 21
        targetSdk = 33
    }
}

getenv("GITHUB_REPOSITORY")?.let {
    publishing {
        repositories {
            maven {
                name = "github"
                url = uri("https://maven.pkg.github.com/$it")
                credentials(PasswordCredentials::class)
            }
        }
    }
}

tasks.named("build") { finalizedBy("createXCFramework") }
tasks.named("clean") { doFirst { delete("swiftpackage") } }
