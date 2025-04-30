package org.example.kmp.all

import androidx.compose.ui.window.Window
import platform.AppKit.NSApp
import platform.AppKit.NSApplication
import platform.posix.getpid
import kotlinx.cinterop.*
import prime.*

/**
 * [master/examples/chat](https://github.com/JetBrains/compose-multiplatform/blob/master/examples/chat/shared/src/macosMain/kotlin/main.macos.kt)
 */
fun main() {
    println("Run ${getPlatform().name} ${getpid()}")
    println("Enter number to check Prime")
    val number = 2
    val output = return_string(is_prime(number))?.toKString()
    println("Returned from C: $output")

    NSApplication.sharedApplication()
    Window(
        title = "CMP Project",
    ) {
        App()
    }
    NSApp?.run()
}