plugins {
    alias(libs.plugins.system.plugin.feature)
    alias(libs.plugins.kotlin.compose)

}

android {
    namespace = "com.my.movie.core.systemdesign"
}

dependencies{
    api(libs.androidx.compose.material.iconsExtended)
}