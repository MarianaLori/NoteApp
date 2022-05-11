package br.senac.noteapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import br.senac.noteapp.data.AppDatabase
import br.senac.noteapp.data.NoteSQLite
import br.senac.noteapp.databinding.ActivityNewBinding

class NewActivity : AppCompatActivity() {
    lateinit var binding: ActivityNewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener {
            val note = NoteSQLite(title = binding.etTitle.text.toString(), desc = binding.etDesc.text.toString())

            //para o código não rodar na thread que está cuidando da tela
            Thread {
                insertNote(note)
            }.start()

            finish()
        }
    }

    fun insertNote(note: NoteSQLite) {
        val db = Room.databaseBuilder(this, AppDatabase::class.java, "db").build()

        db.noteDAO().insert(note)
    }
}