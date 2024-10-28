package com.example.gmaillistapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity

class AddEmailActivity : ComponentActivity() {
    private lateinit var editTextSender: EditText
    private lateinit var editTextSubject: EditText
    private lateinit var editTextPreview: EditText
    private lateinit var buttonAdd: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_email)

        editTextSender = findViewById(R.id.editTextSender)
        editTextSubject = findViewById(R.id.editTextSubject)
        editTextPreview = findViewById(R.id.editTextPreview)
        buttonAdd = findViewById(R.id.buttonAdd)

        buttonAdd.setOnClickListener {
            val newEmail = Email(
                sender = editTextSender.text.toString(),
                subject = editTextSubject.text.toString(),
                preview = editTextPreview.text.toString()
            )

            val resultIntent = Intent()
            resultIntent.putExtra("newEmail", newEmail)

            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}
