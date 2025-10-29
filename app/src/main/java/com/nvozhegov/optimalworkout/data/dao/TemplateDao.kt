package com.nvozhegov.optimalworkout.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.nvozhegov.optimalworkout.data.model.Template
import kotlinx.coroutines.flow.Flow

@Dao
interface TemplateDao {
    @Insert
    suspend fun create(template: Template)

    @Query("SELECT * FROM templates")
    fun getAllTemplates(): Flow<List<Template>>
}