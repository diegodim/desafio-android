plugins {
    id("kotlin")
    id("kotlin-kapt")
}

dependencies{
    val useCase = Dependencies.Modules.UseCase
    val core = Dependencies.Modules.Core

    api(project(useCase.contacts))
    implementation(project(core.commons))

}