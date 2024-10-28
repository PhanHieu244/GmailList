package com.example.gmaillistapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : ComponentActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var emailAdapter: EmailAdapter
    private val emailList = mutableListOf<Email>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_email_list)
        recyclerView = findViewById(R.id.recyclerView)
        val clickListener: (Email) -> Unit = { email ->
            println("Clicked on email from: ${email.sender}")
        }
        emailAdapter = EmailAdapter(emailList, clickListener)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = emailAdapter

        val addEmailLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val newEmail = result.data?.getParcelableExtra<Email>("newEmail")
                newEmail?.let {
                    emailList.add(it)
                    emailAdapter.notifyItemInserted(emailList.size - 1)
                }
            }
        }

        // Set onClickListener for the FAB
        val fabAddEmail = findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(R.id.fabAddEmail)
        fabAddEmail.setOnClickListener {
            val intent = Intent(this, AddEmailActivity::class.java)
            addEmailLauncher.launch(intent)
        }
    }
}
