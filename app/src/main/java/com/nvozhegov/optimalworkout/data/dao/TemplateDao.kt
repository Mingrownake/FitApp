package com.nvozhegov.optimalworkout.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.nvozhegov.optimalworkout.data.model.Template
import com.nvozhegov.optimalworkout.data.model.TemplateExerciseCrossRef
import com.nvozhegov.optimalworkout.data.model.TemplateWithExercise
import kotlinx.coroutines.flow.Flow

@Dao
interface TemplateDao {
    @Insert
    suspend fun create(template: Template): Long

    @Query("INSERT INTO template_exercise_cross_ref VALUES(:templateId, :exerciseId)")
    suspend fun createTemplateCrossRef(templateId: Int, exerciseId: Int)

    @Query("SELECT * FROM templates")
    fun getAllTemplates(): Flow<List<Template>>

    @Transaction
    @Query("SELECT * FROM templates WHERE template_id = :templateId")
    fun getTemplateWithExercises(templateId: Int): Flow<List<TemplateWithExercise>>
}