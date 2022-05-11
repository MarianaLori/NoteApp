package br.senac.noteapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import br.senac.noteapp.data.AppDatabase
import br.senac.noteapp.data.NoteSQLite
import br.senac.noteapp.data.Notes
import br.senac.noteapp.databinding.ActivityListBinding
import br.senac.noteapp.databinding.NoteCardBinding

class ListActivity : AppCompatActivity() {
    lateinit var binding: ActivityListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fabAdd.setOnClickListener{
            val i = Intent(this, NewActivity::class.java)

            startActivity(i)
        }
    }

    //função que chama a atualização toda vez que a tela é carregada
    override fun onResume() {
        super.onResume()
        updateNotes()
    }

    //vai pro banco e traz as notas
    fun updateNotes() {
        Thread {
            val db = Room.databaseBuilder(this, AppDatabase::class.java, "db").build()

            val list = db.noteDAO().listAll()

            runOnUiThread {
                updateUI(list)
            }
        }.start()
    }

    fun updateUI(list: List<NoteSQLite>) {
        //limpar o que tinha antes pra ele não duplicar registros
        binding.container.removeAllViews()

        list.forEach {
            val card = NoteCardBinding.inflate(layoutInflater)

            card.textTitle.text = it.title
            card.textDesc.text = it.desc

            binding.container.addView(card.root) //no parâmetro eu tô pegando a tela do cartão, por isso o root
        }
    }
}