plugins {
    id("kotlin")
    id("kotlin-kapt")
}

dependencies {
    val core = Dependencies.Modules.Core
    val external = Dependencies.External
    val repository = Dependencies.Modules.Repository
    val test = Dependencies.Test

    implementation(project(core.commons))
    implementation(project(repository.repository))
    
    implementation(external.retrofit)
    implementation(external.retrofitConverterGson)
    implementation(external.okHttp)
    implementation(external.okHttpLoggingInterceptor)

    testImplementation("com.squareup.okhttp3:mockwebserver:4.6.0")
    testImplementation(test.jUnit)
    testImplementation(test.mockK)
    testImplementation(test.coreTest)
    testImplementation(test.coroutinesTest)
    testImplementation(test.coroutinesAndroid)
}
