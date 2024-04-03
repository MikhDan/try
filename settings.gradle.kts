pluginManagement {
    repositories {
        google()
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

rootProject.name = "try"
include(":app")
include(":mad_screen")
include(":mad_cw1")
include(":mad_cw2")
include(":mad_animation")
include(":mad_many")
include(":mad_cw2_2")
include(":mad_cw3")
include(":mad_timer")
include(":mad_timer_image")
include(":mad_starik")
