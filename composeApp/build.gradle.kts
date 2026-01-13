import com.codingfeline.buildkonfig.compiler.FieldSpec.Type.STRING
import io.kotzilla.gradle.ext.KotzillaKeyGeneration
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import java.util.Properties

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.buildkonfig)
    alias(libs.plugins.google.services)
    alias(libs.plugins.crashlytics)
    alias(libs.plugins.ksp)
    alias(libs.plugins.room)
    alias(libs.plugins.kotzilla)

    // Add the Performance Monitoring Gradle plugin
    alias(libs.plugins.firebase.perf)
}

kotlin {

    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    listOf(
        //iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }

    //jvm("desktop")

    sourceSets {
        //val desktopMain by getting

        androidMain.dependencies {
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)
            implementation(libs.ktor.client.okhttp)
            implementation(libs.play.services.location)
            implementation(libs.koin.android)
            implementation(libs.koin.androidx.compose)
            implementation(libs.ktor.client.android)
            implementation(libs.core.splashscreen)
            // Add the dependency for the Performance Monitoring library
            // When using the BoM, you don't specify versions in Firebase library dependencies
            implementation(project.dependencies.platform(libs.firebase))
            implementation(libs.firebase.perf)
            implementation(libs.firebase.analytics)

        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            //implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodel)
            implementation(libs.androidx.lifecycle.runtime.compose)
            implementation(libs.bundles.ktor)
            implementation(libs.lifecycle.viewmodel.compose)
            api(libs.moko.permissions)
            api(libs.moko.permissions.compose)
            implementation(libs.permissions.location)
            api(libs.koin.core)
            implementation(libs.koin.compose)
            implementation(libs.koin.compose.viewmodel)
            //implementation(libs.navigation.compose)
            implementation(libs.jetbrains.navigation3.ui)
            implementation(libs.jetbrains.lifecycle.viewmodel.nav3)

            implementation(libs.coil.compose)
            implementation(libs.coil.network.ktor3)
            implementation(libs.androidx.room.runtime)
            implementation(libs.sqlite.bundled)
            implementation(libs.material.icons.core)
            implementation(libs.kotlinx.serialization.json)
            implementation(libs.touchlab.kermit)
            implementation(libs.kotzilla.sdk.compose)
            implementation(libs.material3.expressive)
            implementation(libs.datastore)
            implementation(libs.datastore.preferences)
            api(libs.gitlive.firebase.kotlin.crashlytics)

            implementation(libs.kotlinx.datetime)

        }
        kotzilla {
            versionName = "1.0.0" // add your app version name
            keyGeneration = KotzillaKeyGeneration.COMPOSE
            composeInstrumentation = true
        }
        nativeMain.dependencies {
            implementation(libs.ktor.client.darwin)
        }
//        desktopMain.dependencies {
//            implementation(compose.desktop.currentOs)
//            implementation(libs.kotlinx.coroutines.swing)
//            implementation(libs.ktor.client.okhttp)
//        }
    }
}
android {
    namespace = "org.example.weathercrossplatform"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "org.example.weathercrossplatform"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 51
        versionName = "1.0.0"

    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            signingConfig = signingConfigs.getByName("debug")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

}

buildkonfig {
    packageName = "com.example.weathercrossplatform"

    defaultConfigs {
        val properties = Properties()
        val localPropertiesFile = rootProject.file("local.properties")
        localPropertiesFile.inputStream().use { properties.load(it) }

        val apiKey: String = properties.getProperty("API_KEY")
            ?: error("API_KEY is required")
        val apiKey2: String = properties.getProperty("API_KEY2")
            ?: error("API_KEY is required")

        buildConfigField(STRING, "API_KEY", apiKey)
        buildConfigField(STRING, "API_KEY2", apiKey2)
    }
}

dependencies {
    debugImplementation(compose.uiTooling)
    debugImplementation(libs.leakcanary.android)

}

//compose.desktop {
//    application {
//        mainClass = "org.example.weathercrossplatform.MainKt"
//
//        nativeDistributions {
//            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
//            packageName = "org.example.weathercrossplatform"
//            packageVersion = "1.0.0"
//        }
//    }
//}
room {
    schemaDirectory("$projectDir/schemas")
}

dependencies {
    add("kspCommonMainMetadata", libs.androidx.room.compiler)

    add("kspAndroid", libs.androidx.room.compiler)
    //add("kspIosX64", libs.androidx.room.compiler)
    add("kspIosArm64", libs.androidx.room.compiler)
    add("kspIosSimulatorArm64", libs.androidx.room.compiler)

}