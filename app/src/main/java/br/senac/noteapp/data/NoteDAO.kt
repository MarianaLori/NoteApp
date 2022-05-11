package br.senac.noteapp.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NoteDAO {

    @Insert
    fun insert(note: NoteSQLite)

    @Query(value = "SELECT * FROM NoteSQLite")
    fun listAll(): List<NoteSQLite>
}