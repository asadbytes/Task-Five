package com.asadbyte.taskfive

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ChatAdapter(private val items: List<ChatItem>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val TEXT_MESSAGE_SENDER = 0
        const val TEXT_MESSAGE_RECEIVER = 1
        const val IMAGE_MESSAGE_SENDER = 2
        const val IMAGE_MESSAGE_RECEIVER = 3
    }

    override fun getItemViewType(position: Int): Int {
        return when (val item = items[position]) {
            is ChatItem.TextMessage -> if (item.isSender) TEXT_MESSAGE_SENDER else TEXT_MESSAGE_RECEIVER
            is ChatItem.ImageMessage -> if (item.isSender) IMAGE_MESSAGE_SENDER else IMAGE_MESSAGE_RECEIVER
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            TEXT_MESSAGE_SENDER -> TextViewHolder(inflater.inflate(R.layout.item_text_message_sender, parent, false))
            TEXT_MESSAGE_RECEIVER -> TextViewHolder(inflater.inflate(R.layout.item_text_message_receiver, parent, false))
            IMAGE_MESSAGE_SENDER -> ImageViewHolder(inflater.inflate(R.layout.item_image_message_sender, parent, false))
            else -> ImageViewHolder(inflater.inflate(R.layout.item_image_message_receiver, parent, false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = items[position]) {
            is ChatItem.TextMessage -> (holder as TextViewHolder).bind(item)
            is ChatItem.ImageMessage -> (holder as ImageViewHolder).bind(item)
        }
    }

    override fun getItemCount(): Int = items.size

    class TextViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val textView = view.findViewById<TextView>(R.id.textMessage)
        fun bind(item: ChatItem.TextMessage) {
            textView.text = item.message
        }
    }

    class ImageViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val imageView = view.findViewById<ImageView>(R.id.imageMessage)
        fun bind(item: ChatItem.ImageMessage) {
            Glide.with(imageView.context).load(item.imageUrl).into(imageView)
        }
    }
}