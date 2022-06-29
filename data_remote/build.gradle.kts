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

    testImplementation(test.jUnit)
    testImplementation(test.mockK)
    testImplementation(test.coroutinesTest)
}
