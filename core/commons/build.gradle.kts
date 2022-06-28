plugins {
    id("kotlin")
    id("kotlin-kapt")
}

dependencies {
    val external = Dependecies.External
    val android = Dependecies.Android
    api(external.koinCore)
    api(android.coroutinesCore)
}