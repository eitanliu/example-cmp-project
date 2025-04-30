package org.example.kmp.all

class NativePlatform: Platform {
    override val name: String = "Native Platform"
}

actual fun getPlatform(): Platform = NativePlatform()