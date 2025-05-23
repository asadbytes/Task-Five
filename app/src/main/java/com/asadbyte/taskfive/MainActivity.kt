package com.asadbyte.taskfive

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var chatAdapter: ChatAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.chatRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val chatItems = listOf(
            ChatItem.TextMessage("Hi, how are you?", isSender = false),
            ChatItem.TextMessage("I'm good! What about you?", isSender = true),
            ChatItem.TextMessage("I'm also good, send me a random pic.", isSender = false),
            ChatItem.ImageMessage("https://picsum.photos/200", isSender = true),
            ChatItem.TextMessage("here it is", isSender = true),
            ChatItem.ImageMessage("https://picsum.photos/200", isSender = false),
            ChatItem.TextMessage("here's one from me", isSender = false),
            ChatItem.TextMessage("that's the same pic i sent to you", isSender = true)
        )

        chatAdapter = ChatAdapter(chatItems)
        recyclerView.adapter = chatAdapter
    }
}
