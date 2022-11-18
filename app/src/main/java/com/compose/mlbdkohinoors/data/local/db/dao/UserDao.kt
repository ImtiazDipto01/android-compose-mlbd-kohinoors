package com.compose.mlbdkohinoors.data.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.compose.mlbdkohinoors.data.local.db.entity.UserEntity

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: UserEntity)

    @Query("delete from user")
    suspend fun deleteUsers()

    @Query("select * from user where uid = :uid")
    suspend fun getUser(uid: String): UserEntity
}