plugins {
    kotlin("jvm") version "1.6.10"
    java
}

repositories {
    mavenCentral()
    maven { url = uri("https://jitpack.io") }
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("com.github.quantisbr:brazilian-calendar:1.0.0")
}