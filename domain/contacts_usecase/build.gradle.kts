plugins {
    id("kotlin")
    id("kotlin-kapt")
}

dependencies{
    val core = Dependencies.Modules.Core

    implementation(project(core.commons))
}