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

    api(android.corektx)
    api(android.composeUi)
    api(android.material)
    api(android.composeUiToolPreview)
    api(android.lifecycleRuntime)
    api(android.composeActivity)
    testImplementation(test.jUnit)
    androidTestImplementation(androidTest.jUnit)
    androidTestImplementation(androidTest.espressoCore)
    androidTestImplementation(androidTest.composeUiTest)
    debugImplementation(android.composeUiTool)
    debugImplementation(android.composeUiTest)
}