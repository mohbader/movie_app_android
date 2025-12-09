plugins {
    alias(libs.plugins.system.plugin.feature)
    alias(libs.plugins.kotlin.compose)
    id("kotlinx-serialization")
}

android {
    namespace = "com.my.movie.core.navigation"
}
dependencies{
    implementation(libs.kotlin.serialization.json)
}