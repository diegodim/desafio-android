plugins {
    id("kotlin")
    id("kotlin-kapt")
}

dependencies {
    val core = Dependecies.Modules.Core
    val external = Dependecies.External
    val repository = Dependecies.Modules.Repository

    implementation(project(core.commons))
    implementation(project(repository.repository))
    
    implementation(external.retrofit)
    implementation(external.retrofitConverterGson)
    implementation(external.okHttp)
    implementation(external.okHttpLoggingInterceptor)

}
