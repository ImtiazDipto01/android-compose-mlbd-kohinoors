package com.compose.mlbdkohinoors.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.compose.mlbdkohinoors.data.local.db.dao.UserDao
import com.compose.mlbdkohinoors.data.local.db.entity.UserEntity

@Database(
    entities = [UserEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {

        const val DATABASE_NAME: String = "motf_db"
    }
}