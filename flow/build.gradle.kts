import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework
import org.jetbrains.kotlin.gradle.targets.native.tasks.KotlinNativeTest
import java.lang.System.getenv

plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization") version "2.1.0"
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

    androidTarget {
        publishLibraryVariants("release", "debug")
    }

    val xcf = XCFramework()
    iosX64 {
        binaries {
            framework {
                baseName = "Flow"
                xcf.add(this)
            }
        }
    }

    iosArm64 {
        binaries {
            framework {
                baseName = "Flow"
                xcf.add(this)
            }
        }
    }

    val coroutineVersion = "1.9.0"
    val ktorVersion = "2.3.9"
    val kotlincrypto = "0.5.3"
    sourceSets {
        commonMain {
            resources.srcDirs("src/commonMain/resources")
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
                implementation("io.ktor:ktor-client-websockets:$ktorVersion")

                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.3")
                implementation("com.ionspin.kotlin:bignum:0.3.10")
                implementation("com.ionspin.kotlin:bignum-serialization-kotlinx:0.3.10")
                implementation("com.ionspin.kotlin:bignum:0.3.10-SNAPSHOT")

                implementation("org.kotlincrypto.hash:sha2:$kotlincrypto")
                implementation("org.kotlincrypto.hash:sha3:$kotlincrypto")
            }
        }
        commonTest {
            resources.srcDirs("src/commonTest/resources")
            dependencies {
                implementation(kotlin("test"))
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutineVersion")
                implementation("org.slf4j:slf4j-simple:2.0.9")
            }
        }
        androidUnitTest {
            resources.srcDirs("src/commonTest/resources", "src/commonMain/resources" )
        }
        androidMain {
            dependencies {
                implementation("io.ktor:ktor-client-okhttp:$ktorVersion")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutineVersion")
                implementation("org.bouncycastle:bcprov-jdk15on:1.70")
            }
        }
        iosMain {
            dependencies {
                implementation("io.ktor:ktor-client-darwin:$ktorVersion")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-native:1.3.8")
            }
        }
        iosTest
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

tasks.withType<Copy>().configureEach {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}

// Disable iOS tests
tasks.withType<Test>().configureEach {
    if (name.contains("ios", ignoreCase = true)) {
        enabled = false
    }
}
tasks.withType<KotlinNativeTest>().configureEach {
    if (name.contains("ios", ignoreCase = true)) {
        enabled = false
    }
}

tasks.named("build") { finalizedBy("createXCFramework") }
tasks.named("clean") { doFirst { delete("swiftpackage") } }

