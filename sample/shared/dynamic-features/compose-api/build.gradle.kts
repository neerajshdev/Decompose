import com.arkivanov.gradle.iosCompat
import com.arkivanov.gradle.setupMultiplatform
import com.arkivanov.gradle.setupSourceSets

plugins {
    id("kotlin-multiplatform")
    id("com.android.library")
    id("org.jetbrains.compose")
    id("com.arkivanov.gradle.setup")
}

setupMultiplatform {
    android()
    jvm()
    iosCompat()
    js(IR) { browser() }
}

android {
    namespace = "com.arkivanov.sample.shared.dynamicfeatures.composeapi"
}

kotlin {
    setupSourceSets {
        common.main.dependencies {
            implementation(project(":sample:shared:dynamic-features:api"))
            implementation(compose.runtime)
            implementation(compose.ui)
        }
    }
}
