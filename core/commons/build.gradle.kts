plugins {
    id("kotlin")
    id("kotlin-kapt")
}

dependencies {
    val external = Dependencies.External
    val android = Dependencies.Android
    api(external.koinCore)
    api(android.coroutinesCore)
}