package com.example.gmaillistapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Email(
    val sender: String,   // Địa chỉ email của người gửi
    val subject: String,  // Tiêu đề của email
    val preview: String   // Nội dung tóm tắt của email
) : Parcelable
