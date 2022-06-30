object Dependencies {
    object Modules {
        object Core {
            const val uiKit = ":core:ui_kit"
            const val commons = ":core:commons"
            const val intent = ":core:intent"
            const val core = ":core:core"
        }

        object Features {
            const val contacts = ":features:contacts"
        }

        object Data {
            const val remote = ":data_remote"
            const val local = ":data_local"
        }

        object Repository {
            const val repository = ":repository"
        }

        object UseCase {
            const val contacts = ":domain:contacts_usecase"
        }
    }

    object Android {
        const val androidCoreKotlin = "androidx.core:core-ktx:1.8.0"
        const val composeUi = "androidx.compose.ui:ui:1.1.1"
        const val material = "androidx.compose.material:material:1.1.1"
        const val composeUiToolPreview = "androidx.compose.ui:ui-tooling-preview:1.1.1"
        const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:2.4.1"
        const val composeActivity = "androidx.activity:activity-compose:1.4.0"
        const val composeUiTool = "androidx.compose.ui:ui-tooling:1.1.1"
        const val composeUiTest = "androidx.compose.ui:ui-test-manifest:1.1.1"
        const val systemUiController =
            "com.google.accompanist:accompanist-systemuicontroller:0.24.12-rc"
        const val insetsUi = "com.google.accompanist:accompanist-insets-ui:0.24.12-rc"
        const val navigation = "androidx.navigation:navigation-compose:2.4.1"
        const val navigationAnimation =
            "com.google.accompanist:accompanist-navigation-animation:0.24.12-rc"
        const val navigationCommon = "androidx.navigation:navigation-common-ktx:2.4.1"
        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9"
        const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.9"
        const val roomRuntime = "androidx.room:room-runtime:2.4.2"
        const val roomKotlin = "androidx.room:room-ktx:2.4.2"
        const val roomCompiler = "androidx.room:room-compiler:2.4.2"
    }

    object External {
        const val koinCore = "io.insert-koin:koin-core:3.1.5"
        const val koinAndroid = "io.insert-koin:koin-android:3.1.5"
        const val koinCompose = "io.insert-koin:koin-androidx-compose:3.1.5"
        const val glide = "com.github.skydoves:landscapist-glide:1.4.9"
        const val okHttp = "com.squareup.okhttp3:okhttp:4.9.1"
        const val okHttpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:4.9.1"
        const val retrofit = "com.squareup.retrofit2:retrofit:2.9.0"
        const val retrofitConverterGson = "com.squareup.retrofit2:converter-gson:2.9.0"
        const val leakCanary = "com.squareup.leakcanary:leakcanary-android:2.9.1"
    }

    object Test {
        const val jUnit = "junit:junit:4.13.2"
        const val mockK = "io.mockk:mockk:1.12.3"
        const val assertK = "com.willowtreeapps.assertk:assertk-jvm:0.24"
        const val coreTest = "androidx.arch.core:core-testing:2.1.0"
        const val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.0"
        const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.0"
    }

    object AndroidTest {
        const val jUnit = "androidx.test.ext:junit:1.1.3"
        const val espressoCore = "androidx.test.espresso:espresso-core:3.4.0"
        const val composeUiTest = "androidx.compose.ui:ui-test-junit4:1.1.1"
    }

}