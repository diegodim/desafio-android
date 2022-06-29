plugins {
    id("kotlin")
    id("kotlin-kapt")
}

dependencies{
    val useCase = Dependencies.Modules.UseCase
    val core = Dependencies.Modules.Core
    val test = Dependencies.Test

    api(project(useCase.contacts))
    implementation(project(core.commons))

    testImplementation(test.jUnit)
    testImplementation(test.mockK)
    testImplementation(test.coreTest)
    testImplementation(test.coroutinesTest)
    testImplementation(test.coroutinesAndroid)
}