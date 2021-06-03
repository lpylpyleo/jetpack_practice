package com.example.jetpackpractice.data

data class Card(val id: Int, val name: String, val resourceId: String) {
    var noFrame = false

    val imageUrl: String
        get() {
            return "https://storage.matsurihi.me/mltd/card/$resourceId" + "_0" + if (!noFrame) "_a.png" else "_b.png"
        }

    override fun toString(): String {
        return imageUrl
    }
}