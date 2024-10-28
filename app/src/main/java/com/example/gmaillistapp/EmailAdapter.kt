package com.example.gmaillistapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EmailAdapter(private val emails: List<Email>, private val clickListener: (Email) -> Unit) : RecyclerView.Adapter<EmailAdapter.EmailViewHolder>() {

    inner class EmailViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewSender: TextView = view.findViewById(R.id.textViewSender)
        val textViewSubject: TextView = view.findViewById(R.id.textViewSubject)
        val textViewPreview: TextView = view.findViewById(R.id.textViewPreview)

        fun bind(email: Email, clickListener: (Email) -> Unit) {
            textViewSender.text = email.sender
            textViewSubject.text = email.subject
            textViewPreview.text = email.preview
            itemView.setOnClickListener { clickListener(email) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmailViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.email_item, parent, false)
        return EmailViewHolder(view)
    }

    override fun onBindViewHolder(holder: EmailViewHolder, position: Int) {
        holder.bind(emails[position], clickListener)
    }

    override fun getItemCount() = emails.size
}
