plugins {
    alias(libs.plugins.system.plugin.presentation)
    alias(libs.plugins.kotlin.compose)
}
android {
    namespace = "com.my.movie.main.presentation"
}
dependencies{
    implementation(libs.adaptive.nav.suite)
}