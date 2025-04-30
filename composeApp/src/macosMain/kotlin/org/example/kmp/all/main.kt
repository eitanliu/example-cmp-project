package org.example.kmp.all

import androidx.compose.ui.window.Window
import platform.AppKit.NSApp
import platform.AppKit.NSApplication

/**
 * [master/examples/chat](https://github.com/JetBrains/compose-multiplatform/blob/master/examples/chat/shared/src/macosMain/kotlin/main.macos.kt)
 */
fun main() {
    println("Run ${getPlatform().name}")

    NSApplication.sharedApplication()
    Window(
        title = "CMP Project",
    ) {
        App()
    }
    NSApp?.run()
}