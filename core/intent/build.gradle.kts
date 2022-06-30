plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

apply("../../android-common.gradle")

dependencies {
    val android = Dependencies.Android
    val test = Dependencies.Test
    val androidTest = Dependencies.AndroidTest
    val core = Dependencies.Modules.Core
    val features = Dependencies.Modules.Features
    val external = Dependencies.External

    implementation(project(core.uiKit))

    api(project(features.contacts))

    api(android.navigationCommon)
    api(android.navigation)
    api(android.navigationAnimation)

    implementation(external.koinAndroid)
    implementation(external.koinCompose)

    testImplementation(test.jUnit)

    androidTestImplementation(androidTest.jUnit)
    androidTestImplementation(androidTest.espressoCore)
    androidTestImplementation(androidTest.composeUiTest)

    debugImplementation(android.composeUiTool)
    debugImplementation(android.composeUiTest)
}