plugins {
    `kotlin-dsl`
}

group = "com.mymovie.buildlogic"

java {

    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

dependencies {
    implementation(libs.androidx.room.gradle.plugin)
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplicationCompose") {
            id = "movieapp.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        register("androidApplication") {
            id = "movieapp.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = "movieapp.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
        register("androidLibrary") {
            id = "movieapp.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidFeature") {
            id = "movieapp.android.feature"
            implementationClass = "AndroidFeatureConventionPlugin"
        }
        register("androidHilt") {
            id = "movieapp.android.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }
        register("androidRoom") {
            id = "movieapp.android.room"
            implementationClass = "AndroidRoomConventionPlugin"
        }
        register("appFlavors") {
            id = "movieapp.app.flavors"
            implementationClass = "AndroidApplicationFlavorsConventionPlugin"
        }

        register("androidDomain") {
            id = "movieapp.android.domain"
            implementationClass = "AndroidDomainConventionPlugin"
        }

        register("androidPresentation") {
            id = "movieapp.android.presentation"
            implementationClass = "AndroidPresentationConventionPlugin"
        }

        register("androidNavigationPlugin") {
            id = "movieapp.android.navigation"
            implementationClass = "AndroidNavigationConventionPlugin"
        }
    }
}