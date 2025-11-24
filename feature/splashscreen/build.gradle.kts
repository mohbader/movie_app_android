plugins {
    alias(libs.plugins.system.plugin.presentation)
    alias(libs.plugins.kotlin.compose)
}

android{
    namespace="com.my.movieapp.feature.splashscreen"
}
dependencies {
    implementation(project(":feature:main:presentation"))
}