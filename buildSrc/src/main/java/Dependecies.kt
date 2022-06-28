object Dependecies {
    object Modules {
        object Core {
            const val uiKit = ":core:ui_kit"
            const val commons = ":core:commons"
            const val intent = ":core:intent"
            const val core = ":core:core"
        }
    }

    object Android {
        const val corektx = "androidx.core:core-ktx:1.8.0"
        const val composeUi = "androidx.compose.ui:ui:1.1.1"
        const val material = "androidx.compose.material:material:1.1.1"
        const val composeUiToolPreview = "androidx.compose.ui:ui-tooling-preview:1.1.1"
        const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:2.4.1"
        const val composeActivity = "androidx.activity:activity-compose:1.4.0"
        const val composeUiTool = "androidx.compose.ui:ui-tooling:1.1.1"
        const val composeUiTest = "androidx.compose.ui:ui-test-manifest:1.1.1"
    }

    object External{
        const val koinCore = "io.insert-koin:koin-core:3.1.5"
        const val koinAndroid = "io.insert-koin:koin-android:3.1.5"
        const val koinCompose = "io.insert-koin:koin-androidx-compose:3.1.5"
    }

    object Test {
        const val jUnit = "junit:junit:4.13.2"
    }

    object AndroidTest {
        const val jUnit = "androidx.test.ext:junit:1.1.3"
        const val espressoCore = "androidx.test.espresso:espresso-core:3.4.0"
        const val composeUiTest = "androidx.compose.ui:ui-test-junit4:1.1.1"
    }

}