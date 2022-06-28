plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

apply("../android-common.gradle")

android {
    defaultConfig.applicationId = "com.picpay.desafio.android"
}

dependencies {
    val android = Dependecies.Android
    val test = Dependecies.Test
    val androidTest = Dependecies.AndroidTest
    val core = Dependecies.Modules.Core

    implementation(project(core.uiKit))
    testImplementation(test.jUnit)
    androidTestImplementation(androidTest.jUnit)
    androidTestImplementation(androidTest.espressoCore)
    androidTestImplementation(androidTest.composeUiTest)
    debugImplementation(android.composeUiTool)
    debugImplementation(android.composeUiTest)
}