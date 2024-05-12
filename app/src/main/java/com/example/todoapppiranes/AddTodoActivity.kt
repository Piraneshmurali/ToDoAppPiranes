package com.example.todoapppiranes

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.todoapppiranes.databinding.ActivityAddTodoBinding

class AddTodoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddTodoBinding
    private lateinit var db:NotesDatabaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityAddTodoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db=NotesDatabaseHelper(this)

        binding.saveButton.setOnClickListener{
            val title=binding.titleEditText.text.toString()
            val content=binding.contentEditText.text.toString()
            val note = Note(0,title,content)
            db.insertNote(note)
            finish()
            Toast.makeText(this, "Note Saved", Toast.LENGTH_SHORT).show();
        }

    }
}