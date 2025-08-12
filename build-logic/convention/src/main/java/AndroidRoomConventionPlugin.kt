
import androidx.room.gradle.RoomExtension
import com.my.convention.libs
import com.my.convention.roomCompiler
import com.my.convention.roomKts
import com.my.convention.roomRuntime
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class AndroidRoomConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("androidx.room")
            pluginManager.apply("com.google.devtools.ksp")

            extensions.configure<RoomExtension> {
                schemaDirectory("$projectDir/schemas")
            }

            dependencies {
                add("implementation", libs.roomRuntime)
                add("implementation", libs.roomKts)
                add("ksp", libs.roomCompiler)
            }
        }
    }
}