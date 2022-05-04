package br.senac.noteapp.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.senac.noteapp.data.Note
import br.senac.noteapp.data.Notes
import br.senac.noteapp.databinding.ActivityNewNoteBinding

class NewNoteActivity : AppCompatActivity() {
    lateinit var binding: ActivityNewNoteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnAdd.setOnClickListener {
            val note = Note(binding.etTitle.text.toString(), binding.etDesc.text.toString())

            Notes.noteList.add(note)

            //vou colocar o comando pra encerrar a atividade assim que inserir o item, pra não precisar voltar manualmente
            finish()
        }
    }

}