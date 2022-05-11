package br.senac.noteapp.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(NoteSQLite::class), version = 1) //version cria uma versão da base
abstract class AppDatabase: RoomDatabase() {
    abstract fun noteDAO(): NoteDAO

}