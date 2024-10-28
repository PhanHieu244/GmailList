package com.example.gmaillistapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomEmailAdapter (val emails: ArrayList<ItemModel>): BaseAdapter() {
    override fun getCount(): Int {
        return emails.size
    }

    override fun getItem(position: Int): Any {
        return emails[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var itemView: View
        itemView = LayoutInflater.from(parent?.context).inflate(R.layout.layout_item, parent, false)
        itemView.findViewById<ImageView>(R.id.image_thumb).setImageResource(emails[position].imageResource)
        itemView.findViewById<TextView>(R.id.title_email).text = emails[position].title
        itemView.findViewById<TextView>(R.id.email_caption).text = emails[position].emailBrief
        itemView.findViewById<TextView>(R.id.time_sent).text = emails[position].timeSent
        return itemView
    }
}