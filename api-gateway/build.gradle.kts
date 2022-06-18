import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.7.0"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm") version "1.6.21"
	kotlin("plugin.spring") version "1.6.21"
}

group = "com.prime-football"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
}

dependencies {

	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

//	implementation("org.springframework.cloud:spring-cloud-starter-config:3.1.3")
//	implementation("org.springframework.cloud:spring-cloud-config-client:3.1.3")
//	implementation("org.springframework.cloud:spring-cloud-config-server:3.1.3")

	implementation("org.springframework.cloud:spring-cloud-starter-gateway:3.1.3")
	implementation("org.springframework.cloud:spring-cloud-starter-circuitbreaker-resilience4j:2.1.3")

	implementation("org.springframework.boot:spring-boot-starter-oauth2-resource-server")
	implementation("org.springframework.boot:spring-boot-starter-security")

	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("com.google.firebase:firebase-admin:8.2.0")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.security:spring-security-test")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
