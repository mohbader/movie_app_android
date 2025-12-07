import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidPresentationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("movieapp.android.library")
                apply("movieapp.android.hilt")
                apply("movieapp.android.library.compose")
                apply("movieapp.android.feature")
            }


            dependencies {
                add("implementation", project(":core:theme"))
                add("implementation", project(":core:navigation"))
            }
        }
    }
}