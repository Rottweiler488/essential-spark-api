plugins {
	java
}

group = "com.rottweiler488"
version = "1.0.0"

repositories {
	mavenCentral()
}

dependencies {
}

tasks.test {
	useJUnitPlatform()
}
