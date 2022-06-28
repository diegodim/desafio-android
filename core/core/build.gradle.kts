plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

apply("../../android-common.gradle")

dependencies {
    val android = Dependecies.Android
    val test = Dependecies.Test
    val androidTest = Dependecies.AndroidTest
    val core = Dependecies.Modules.Core
    val external = Dependecies.External

    api(project(core.uiKit))
    api(project(core.commons))

    api(external.koinAndroid)
    api(external.koinCompose)
    api(android.coroutines)

    testImplementation(test.jUnit)

    androidTestImplementation(androidTest.jUnit)
    androidTestImplementation(androidTest.espressoCore)
    androidTestImplementation(androidTest.composeUiTest)

    debugImplementation(android.composeUiTool)
    debugImplementation(android.composeUiTest)
}