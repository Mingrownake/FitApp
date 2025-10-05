package com.nvozhegov.optimalworkout.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nvozhegov.optimalworkout.data.dao.ExerciseDao
import com.nvozhegov.optimalworkout.data.model.Exercise

@Database(entities = [Exercise::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun exerciseDao(): ExerciseDao
}