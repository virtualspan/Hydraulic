enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS) // ✅ Added

    repositories {
        //        mavenLocal()
        mavenCentral()

        gradlePluginPortal()

        // Geyser, Floodgate, Cumulus etc.
        maven("https://repo.opencollab.dev/main/")

        // Minecraft
        maven("https://libraries.minecraft.net") {
            name = "minecraft"
            mavenContent {
                releasesOnly()
            }
        }

        // Architectury
        maven("https://maven.architectury.dev/")

        // NeoForge
        maven("https://maven.neoforged.net/releases/")

        // Fabric
        maven("https://maven.fabricmc.net/")

        // Sponge Snapshots
        maven("https://repo.spongepowered.org/repository/maven-public/")

        // PackConverter
        maven("https://jitpack.io") {
            content {
                includeGroupByRegex("com\\.github\\..*")
            }
        }

        // ✅ Added JitPack fallback
        maven { url = uri("https://jitpack.io") }
    }
}

pluginManagement {
    repositories {
        gradlePluginPortal()

        maven("https://repo.opencollab.dev/main/")
        maven("https://jitpack.io") {
            content {
                includeGroupByRegex("com\\.github\\..*")
            }
        }

        maven("https://maven.architectury.dev/")
        maven("https://maven.neoforged.net/releases")
        maven("https://maven.fabricmc.net/")

        // Java pack library
        maven("https://repo.unnamed.team/repository/unnamed-public/")
    }

    plugins {
        id("net.kyori.blossom") version "1.2.0"
        id("net.kyori.indra")
        id("net.kyori.indra.git")
    }

    includeBuild("build-logic")
}

rootProject.name = "hydraulic-parent"

include(":shared")
include(":fabric")
include(":neoforge")
include(":test")
