plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

apply("../android-common.gradle")

dependencies {
    val android = Dependencies.Android
    val test = Dependencies.Test
    val androidTest = Dependencies.AndroidTest
    val core = Dependencies.Modules.Core
    val repository = Dependencies.Modules.Repository

    implementation(project(core.core))
    implementation(project(repository.repository))

    implementation(android.roomRuntime)
    implementation(android.roomKotlin)
    kapt(android.roomCompiler)

    testImplementation(test.jUnit)
    testImplementation(test.mockK)
    testImplementation(test.coreTest)
    testImplementation(test.coroutinesTest)
    testImplementation(test.coroutinesAndroid)

    androidTestImplementation(androidTest.jUnit)
    androidTestImplementation(test.coreTest)
    androidTestImplementation(androidTest.espressoCore)
    androidTestImplementation(androidTest.composeUiTest)

    debugImplementation(android.composeUiTool)
    debugImplementation(android.composeUiTest)
}
