plugins {
	java
	id("org.springframework.boot") version "3.5.3"
	id("io.spring.dependency-management") version "1.1.7"
	checkstyle
}

group = "com.rottweiler488"
version = "0.1.0-SNAPSHOT"

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

checkstyle {
	toolVersion = "13.6.0"
}

tasks.named<Checkstyle>("checkstyleMain") {
	configFile = file("config/checkstyle/checkstyle.xml")
}

tasks.named<Checkstyle>("checkstyleTest") {
	configFile = file("config/checkstyle/checkstyle-test.xml")
}

tasks.test {
	useJUnitPlatform()
}

tasks.bootJar {
	archiveFileName.set("esapp-latest.jar");
}

tasks.jar {
	enabled = false
}
