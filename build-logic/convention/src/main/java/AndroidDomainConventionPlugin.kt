import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidDomainConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("movieapp.android.library")
                apply("movieapp.android.hilt")
            }
        }
    }
}