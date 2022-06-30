plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

apply("../android-common.gradle")

android {
    defaultConfig.applicationId = "com.picpay.desafio.android"
}

dependencies {
    val android = Dependencies.Android
    val external = Dependencies.External
    val test = Dependencies.Test
    val androidTest = Dependencies.AndroidTest
    val core = Dependencies.Modules.Core
    val data = Dependencies.Modules.Data
    val repository = Dependencies.Modules.Repository

    implementation(project(core.core))
    implementation(project(core.intent))
    implementation(project(data.remote))
    implementation(project(data.local))
    implementation(project(repository.repository))

    testImplementation(test.jUnit)

    androidTestImplementation(androidTest.jUnit)
    androidTestImplementation(androidTest.espressoCore)
    androidTestImplementation(androidTest.composeUiTest)

    debugImplementation(android.composeUiTool)
    debugImplementation(android.composeUiTest)
    debugImplementation(external.leakCanary)
}