This is a Kotlin Multiplatform project targeting Android, iOS, Desktop.

* `/composeApp` is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - `commonMain` is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
    `iosMain` would be the right folder for such calls.

* `/iosApp` contains iOS applications. Even if you’re sharing your UI with Compose Multiplatform, 
  you need this entry point for your iOS app. This is also where you should add SwiftUI code for your project.


Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)…

[Get started with Kotlin/Native](https://kotlinlang.org/docs/native-get-started.html)  
[Kotlin Multiplatform Wizard](https://kmp.jetbrains.com/)  
[Klibs Compose UI](https://klibs.io/?tags=Compose+UI)  
[kmp-awesome](https://github.com/terrakok/kmp-awesome)
[compose-multiplatform](https://github.com/JetBrains/compose-multiplatform)  
[Kotlin Multiplatform Development Documentation](https://www.jetbrains.com/help/kotlin-multiplatform-dev)  
[kotlin-multiplatform-dev-docs/compose-navigation.md](https://github.com/JetBrains/kotlin-multiplatform-dev-docs/blob/master/topics/compose/compose-navigation.md)  
[Api | kotlinx.coroutines](https://kotlinlang.org/api/kotlinx.coroutines)  

[Android BOM to library version mapping](https://developer.android.com/develop/ui/compose/bom/bom-mapping)  
[Jetbrains Maven dev: org/jetbrains/compose](https://maven.pkg.jetbrains.space/public/p/compose/dev/org/jetbrains/compose/)  
[Maven Central: org.jetbrains.androidx.navigation:navigation-compose](https://central.sonatype.com/artifact/org.jetbrains.androidx.navigation/navigation-compose)  
[Maven Repository: org.jetbrains.compose » org.jetbrains.compose.gradle.plugin](https://mvnrepository.com/artifact/org.jetbrains.compose/org.jetbrains.compose.gradle.plugin)

[Kotlin/KMP-App-Template-Native](https://github.com/Kotlin/KMP-App-Template-Native)
[Kotlin/kmp-native-wizard](https://github.com/Kotlin/kmp-native-wizard)

kotlin coroutines posix
[Support for runInterruptible in Kotlin/Native (POSIX) targets](https://github.com/Kotlin/kotlinx.coroutines/issues/3563)
[Kotlin/Native as a dynamic library — tutorial](https://medium.com/@bppleman/kotlin-native-as-a-dynamic-library-tutorial-c1b844a401bc)
[Kotlin/Native Immediate-Mode-UI/Nuklear]((https://gist.github.com/RageshAntony/d25232763682d2a15acbabaa1cca08bc)