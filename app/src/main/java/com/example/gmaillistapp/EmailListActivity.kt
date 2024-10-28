package com.example.gmaillistapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class EmailListActivity : ComponentActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var emailAdapter: EmailAdapter
    private val emails = mutableListOf<Email>()  // Sử dụng MutableList để thêm mới

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email_list)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Thêm dữ liệu mẫu
        emails.add(Email("user1@example.com", "Chào bạn!", "Đây là một thông điệp mẫu."))
        emails.add(Email("user2@example.com", "Thông báo", "Có một thông báo mới."))

        emailAdapter = EmailAdapter(emails) { email ->
            // Xử lý khi người dùng nhấn vào email
        }
        recyclerView.adapter = emailAdapter

        // Thiết lập nút "+" để thêm email mới
        val fabAddEmail: FloatingActionButton = findViewById(R.id.fabAddEmail)
        fabAddEmail.setOnClickListener {
            // Mở Activity để thêm email mới
            val intent = Intent(this, AddEmailActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE_ADD_EMAIL)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_ADD_EMAIL && resultCode == RESULT_OK) {
            data?.getParcelableExtra<Email>("newEmail", )?.let { newEmail ->
                emails.add(newEmail)
                emailAdapter.notifyItemInserted(emails.size - 1)
                recyclerView.scrollToPosition(emails.size - 1)
            }
        }
    }

    companion object {
        const val REQUEST_CODE_ADD_EMAIL = 1
    }
}
