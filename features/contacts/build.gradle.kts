plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
}

apply("../../android-common.gradle")

dependencies {
    val android = Dependencies.Android
    val test = Dependencies.Test
    val androidTest = Dependencies.AndroidTest
    val core = Dependencies.Modules.Core
    val useCase = Dependencies.Modules.UseCase

    implementation(project(core.core))
    implementation(project(useCase.contacts))

    testImplementation(test.jUnit)
    testImplementation(test.mockK)
    testImplementation(test.coreTest)
    testImplementation(test.coroutinesTest)
    testImplementation(test.coroutinesAndroid)

    androidTestImplementation(project(core.uiKit))
    androidTestImplementation(androidTest.jUnit)
    androidTestImplementation(androidTest.espressoCore)
    androidTestImplementation(androidTest.composeUiTest)

    debugImplementation(android.composeUiTool)
    debugImplementation(android.composeUiTest)
}