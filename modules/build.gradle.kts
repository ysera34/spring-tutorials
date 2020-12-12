val kotlinVersion: String by project
val springBootVersion: String by project

buildscript {
    val kotlinVersion: String by project
    val springBootVersion: String by project

    repositories {
        mavenCentral()
        jcenter()
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
        classpath("org.springframework.boot:spring-boot-gradle-plugin:$springBootVersion")
    }
}

plugins {
    val kotlinVersion = "1.3.72"
    val springBootVersion = "2.3.5.RELEASE"
    val dependencyManagementVersion = "1.0.10.RELEASE"

    kotlin("jvm") version kotlinVersion
    kotlin("plugin.spring") version kotlinVersion
    id("org.springframework.boot") version springBootVersion
    id("io.spring.dependency-management") version dependencyManagementVersion
}

allprojects {
    group = "org.inframincer.spring.boot"
    version = "0.0.1-SNAPSHOT"

    repositories {
        mavenCentral()
        jcenter()
    }
}

subprojects {
    apply {
        plugin("kotlin")
        plugin("org.jetbrains.kotlin.jvm")
        plugin("org.jetbrains.kotlin.plugin.spring")
        plugin("org.springframework.boot")
        plugin("io.spring.dependency-management")
    }

    repositories {
        mavenCentral()
        jcenter()
    }

    dependencies {
        implementation("org.springframework.boot:spring-boot-starter-web")
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
        testImplementation("org.springframework.boot:spring-boot-starter-test") {
            exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
        }
    }

    java {
        sourceCompatibility = JavaVersion.VERSION_15
        targetCompatibility = JavaVersion.VERSION_15
    }

    tasks {
        jar {
            enabled = true
        }

        bootJar {
            enabled = false
        }

        compileKotlin {
            kotlinOptions {
                freeCompilerArgs = listOf("-Xjsr305=strict")
                jvmTarget = "13"
            }
        }

        test {
            useJUnitPlatform()
        }
    }
}
