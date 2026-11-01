package com.example.project_mobile.Message

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.bumptech.glide.Glide
import com.example.project_mobile.DetailActivity
import com.example.project_mobile.databinding.ItemMessageBinding

class MessageAdapter(
    context: Context,
    private val messages: List<MessageModel>
) : ArrayAdapter<MessageModel>(context, 0, messages) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding = ItemMessageBinding.inflate(LayoutInflater.from(context), parent, false)
        val view = binding.root
        val data = messages[position]

        Glide.with(context).load(data.avatarUrl).into(binding.avatarImg)
        binding.textSender.text = data.senderName
        binding.textMessage.text = data.messageText
        binding.textTime.text = data.time

        view.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            context.startActivity(intent)
        }
        return view
    }
}
