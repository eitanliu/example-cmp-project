package org.example.kmp.all

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform