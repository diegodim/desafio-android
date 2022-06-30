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
    val external = Dependencies.External

    api(android.androidCoreKotlin)
    api(android.composeUi)
    api(android.material)
    api(android.composeUiToolPreview)
    api(android.lifecycleRuntime)
    api(android.composeActivity)
    api(android.systemUiController)
    api(android.insetsUi)
    api(external.glide)

    testImplementation(test.jUnit)

    androidTestImplementation(androidTest.jUnit)
    androidTestImplementation(androidTest.espressoCore)
    androidTestImplementation(androidTest.composeUiTest)

    debugImplementation(android.composeUiTool)
    debugImplementation(android.composeUiTest)
}