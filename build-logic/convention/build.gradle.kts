plugins {
    `kotlin-dsl`
}

group = "com.mymovie.buildlogic" // Package name for the our plugins

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
}

gradlePlugin {
    plugins {
        // Will add in next step
    }
}