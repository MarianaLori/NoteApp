package br.senac.noteapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.senac.noteapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSing.setOnClickListener {
            val i = Intent(this, ListNotesActivity::class.java)

            startActivity(i)
        }

        binding.buttonSQL.setOnClickListener {
            val i = Intent(this, ListActivity::class.java)

            startActivity(i)
        }
    }
}