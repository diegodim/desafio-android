plugins {
    id("kotlin")
    id("kotlin-kapt")
}

dependencies{
    val core = Dependecies.Modules.Core

    implementation(project(core.commons))
}