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
    val android = Dependecies.Android
    val external = Dependecies.External
    val test = Dependecies.Test
    val androidTest = Dependecies.AndroidTest
    val core = Dependecies.Modules.Core
    val data = Dependecies.Modules.Data
    val repository = Dependecies.Modules.Repository

    implementation(project(core.core))
    implementation(project(core.intent))
    implementation(project(data.remote))
    implementation(project(repository.repository))

    testImplementation(test.jUnit)
    androidTestImplementation(androidTest.jUnit)
    androidTestImplementation(androidTest.espressoCore)
    androidTestImplementation(androidTest.composeUiTest)
    debugImplementation(android.composeUiTool)
    debugImplementation(android.composeUiTest)
    debugImplementation(external.leakCanary)
}