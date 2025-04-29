import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.internal.os.OperatingSystem
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
}

private val os get() = OperatingSystem.current()
private val arch get() = System.getProperty("os.arch")
private val isArm64 get() = arch == "aarch64"

val androidEnable = true
val iosEnable get() = os.isMacOsX //|| true
val desktopEnable = true
val nativeEnable = true

kotlin {

    if (androidEnable) androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    if (iosEnable) listOf(
        iosX64(), iosArm64(), iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }

    if (desktopEnable) jvm("desktop")

    val osNativeTarget = if (nativeEnable) when {
        os.isMacOsX -> if (isArm64) macosArm64("osNative") else macosX64("osNative")
        os.isLinux -> if (isArm64) linuxArm64("osNative") else linuxX64("osNative")
        os.isWindows -> mingwX64("osNative")
        else -> null //throw GradleException("Host OS is not supported in Kotlin/Native.")
    }?.also { nativeTarget ->
        nativeTarget.binaries {
            executable {
                entryPoint = "org.example.kmp.all.main"
            }
        }
    } else null

    sourceSets {
        // val desktopMain by getting

        commonMain.dependencies {
            implementation(compose.animation)
            implementation(compose.animationGraphics)
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.ui)
            implementation(compose.material)
            implementation(compose.material3AdaptiveNavigationSuite)
            implementation(compose.materialIconsExtended)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)

            implementation(project.dependencies.platform(libs.kotlinx.coroutines.bom))
            implementation(project.dependencies.platform(libs.compose.bom))
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.androidx.lifecycle.viewmodel)
            implementation(libs.androidx.lifecycle.runtime.compose)
            implementation(libs.compose.multiplatform.navigation)
        }
        if (androidEnable) androidMain.dependencies {
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)
        }
        if (iosEnable) iosMain.dependencies {
        }
        if (desktopEnable) getByName("desktopMain").dependencies {
            implementation(compose.desktop.currentOs)
            implementation(libs.kotlinx.coroutines.swing)
        }
        if (nativeEnable && osNativeTarget != null) getByName("osNativeMain").dependencies {
        }
    }
}

dependencies {
    if (androidEnable) add("debugImplementation", compose.uiTooling)
}

// extensions.configure<BaseAppModuleExtension>("android") {}
if (androidEnable) extensions.configure<BaseAppModuleExtension>("android") {
    namespace = "org.example.kmp.all"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "org.example.kmp.all"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

// (extensions.getByName("compose") as ComposeExtension).extensions.configure<DesktopExtension> {}
if (desktopEnable) compose.desktop {
    application {
        mainClass = "org.example.kmp.all.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "org.example.kmp.all"
            packageVersion = "1.0.0"
        }
    }
}
