package br.senac.noteapp.activities

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import br.senac.noteapp.data.Notes
import br.senac.noteapp.databinding.ActivityListNotesBinding
import br.senac.noteapp.databinding.NoteCardBinding

class ListNotesActivity : AppCompatActivity() {
    lateinit var binding: ActivityListNotesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListNotesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //configurando o botão que vai abrir a atividade de criação de uma nota
        binding.fabAdd.setOnClickListener {
            val i = Intent(this, NewNoteActivity::class.java)

            startActivity(i)
        }

    }

    //função que chama a atualização toda vez que a tela é carregada
    override fun onResume() {
        super.onResume()
        updateNotes()
    }

    //função que atualiza a lista de notas e joga no container de lista
    fun updateNotes() {
        //limpar o que tinha antes pra ele não duplicar registros
        binding.container.removeAllViews()

        Notes.noteList.forEach {
            val card = NoteCardBinding.inflate(layoutInflater)

            card.textTitle.text = it.title
            card.textDesc.text = it.desc

            binding.container.addView(card.root) //no parâmetro eu tô pegando a tela do cartão, por isso o root
        }
    }

}