pluginManagement {
    includeBuild("build-logic") // Include the build-logic
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "MyMovieApp"

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
include(":app")
include(":feature:splashscreen")
include(":core:theme")
include(":core:navigation")
include(":feature:home:presentation")
include(":feature:favourite:presentation")
include(":feature:details:presentation")
include(":core:systemdesign")
include(":feature:setting:presentation")
