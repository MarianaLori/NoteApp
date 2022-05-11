package br.senac.noteapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NoteSQLite(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    var title: String,
    var desc: String
    )
