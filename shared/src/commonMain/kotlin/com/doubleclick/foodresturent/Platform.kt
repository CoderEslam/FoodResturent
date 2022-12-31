package com.doubleclick.foodresturent

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform