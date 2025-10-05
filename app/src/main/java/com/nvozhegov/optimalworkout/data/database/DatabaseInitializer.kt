package com.nvozhegov.optimalworkout.data.database

import android.content.Context
import android.util.Log
import com.nvozhegov.optimalworkout.data.dao.ExerciseDao
import com.nvozhegov.optimalworkout.data.model.Exercise
import com.nvozhegov.optimalworkout.utils.JsonAssetReader
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.serialization.json.Json
import java.util.concurrent.atomic.AtomicBoolean
import javax.inject.Inject


class DatabaseInitializer @Inject constructor(
    val exerciseDao: ExerciseDao,
    @ApplicationContext val context: Context
) {
    private val initialized = AtomicBoolean(false)

    suspend fun initializeDB() {
        if (initialized.getAndSet(true)) return

        if (exerciseDao.getAll().isEmpty()) {
            try {
                val json = JsonAssetReader.readJsonAsset(context, "exercises.json")
                val exercises = Json.decodeFromString<List<Exercise>>(json)
                    .map {
                        Exercise(it.id, it.title, it.description)
                    }
                exerciseDao.insertAll(exercises)
            } catch (e: Exception) {
                Log.e("DatabaseInitializer", "Failed to load exercises from JSON", e)
            }
        }
    }
}