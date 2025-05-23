package com.asadbyte.taskfive

sealed class ChatItem {
    data class TextMessage(val message: String, val isSender: Boolean): ChatItem()
    data class ImageMessage(val imageUrl: String, val isSender: Boolean): ChatItem()
}
