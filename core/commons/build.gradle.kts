plugins {
    id("kotlin")
    id("kotlin-kapt")
}

dependencies {
    val external = Dependecies.External
    api(external.koinCore)
}