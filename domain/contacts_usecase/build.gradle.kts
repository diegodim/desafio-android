plugins {
    id("kotlin")
    id("kotlin-kapt")
}

dependencies{
    val core = Dependencies.Modules.Core
    val test = Dependencies.Test

    implementation(project(core.commons))

    testImplementation(test.jUnit)
    testImplementation(test.mockK)
    testImplementation(test.coroutinesTest)
}