plugins {
    id("kotlin")
    id("kotlin-kapt")
}

dependencies{
    val useCase = Dependecies.Modules.UseCase
    val core = Dependecies.Modules.Core

    api(project(useCase.contacts))
    implementation(project(core.commons))

}