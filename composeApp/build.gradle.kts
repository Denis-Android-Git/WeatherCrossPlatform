import com.codingfeline.buildkonfig.compiler.FieldSpec.Type.STRING
import java.util.Properties

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.buildkonfig)
    alias(libs.plugins.google.services)
    alias(libs.plugins.ksp)
    alias(libs.plugins.room)
    alias(libs.plugins.kotzilla)
    alias(libs.plugins.androidKmpLibrary)
}

kotlin {
    android {
        compileSdk = 36
        minSdk = 24
        namespace = "org.example.weathercrossplatform.common"
        experimentalProperties["android.experimental.kmp.enableAndroidResources"] = true
    }

    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }

    sourceSets {

        androidMain.dependencies {
            implementation(libs.ui.tooling.preview)
            implementation(libs.ui.tooling)
            implementation(libs.androidx.activity.compose)
            implementation(libs.ktor.client.okhttp)
            implementation(libs.play.services.location)
            implementation(libs.koin.android)
            implementation(libs.koin.androidx.compose)
            implementation(libs.ktor.client.android)
            //implementation(libs.core.splashscreen)
            implementation(project.dependencies.platform(libs.firebase))
            implementation(libs.firebase.perf)
            implementation(libs.firebase.analytics)
            implementation(libs.androidx.lifecycle.process)

        }
        commonMain.dependencies {
            implementation(libs.runtime)
            implementation(libs.foundation)
            implementation(libs.ui)
            implementation(libs.components.resources)
            implementation(libs.ui.tooling.preview)
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
            //Liquid glass
            implementation(libs.backdrop)
            //Adaptive
            implementation(libs.material3.adaptive)
            implementation(libs.material3.adaptive.layout)
            implementation(libs.material3.adaptive.navigation)

        }
        kotzilla {
            versionName = "1.2.0" // add your app version name
            composeInstrumentation = true
        }
        nativeMain.dependencies {
            implementation(libs.ktor.client.darwin)
        }
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

room {
    schemaDirectory("$projectDir/schemas")
}

dependencies {
    add("kspCommonMainMetadata", libs.androidx.room.compiler)
    add("kspAndroid", libs.androidx.room.compiler)
    add("kspIosArm64", libs.androidx.room.compiler)
    add("kspIosSimulatorArm64", libs.androidx.room.compiler)

}

tasks.matching { it.name.startsWith("ksp") }.configureEach {
    dependsOn(tasks.named("generateKotzillaConfig"))
}
