plugins {
    `java-library`
    id("com.github.johnrengelman.shadow").version("7.1.2")
    `maven-publish`
}

repositories {
    mavenCentral()
    mavenLocal()

    maven {
        url = uri("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")

        // As of Gradle 5.1, you can limit this to only those
        // dependencies you expect from it
        content {
            includeGroup("org.bukkit")
            includeGroup("org.spigotmc")
        }
    }

    /*
    As Spigot-API depends on the BungeeCord ChatComponent-API,
    we need to add the Sonatype OSS repository, as Gradle,
    in comparison to maven, doesn't want to understand the ~/.m2
    directory unless added using mavenLocal(). Maven usually just gets
    it from there, as most people have run the BuildTools at least once.
    This is therefore not needed if you're using the full Spigot/CraftBukkit,
    or if you're using the Bukkit API.
    */
    maven { url = uri("https://oss.sonatype.org/content/repositories/snapshots") }
    maven { url = uri("https://oss.sonatype.org/content/repositories/central") }
    maven { url = uri("https://jitpack.io") }
}

tasks {
    build {
        dependsOn(shadowJar)
    }

    shadowJar {
        archiveClassifier.set("")
        configurations = listOf(project.configurations.shadow.get())
        archiveFileName.set("LandsAPI-${project.version}.jar")
        relocate("com.github.angeschossen.pluginframework.api", "me.angeschossen.lands.api.framework")
    }
}

dependencies {
    shadow("com.github.Angeschossen:PluginFrameworkAPI:1.0.0")
    compileOnly("org.spigotmc:spigot-api:1.19.3-R0.1-SNAPSHOT")
    compileOnly("org.realityforge.org.jetbrains.annotations:org.jetbrains.annotations:1.7.0")
}

group = "com.github.angeschossen"
version = "6.26.11"
description = "LandsAPI"
java.sourceCompatibility = JavaVersion.VERSION_1_8

artifacts{
    archives(tasks["shadowJar"])
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "com.github.angeschossen"
            artifactId = "LandsAPI"
            version = "6.26.11"

            from(components["java"])
        }
    }
}