package com.nvozhegov.optimalworkout.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nvozhegov.optimalworkout.data.dao.ExerciseDao
import com.nvozhegov.optimalworkout.data.dao.GroupDao
import com.nvozhegov.optimalworkout.data.dao.TemplateDao
import com.nvozhegov.optimalworkout.data.dao.WorkoutTemplateDao
import com.nvozhegov.optimalworkout.data.model.entity.Exercise
import com.nvozhegov.optimalworkout.data.model.entity.Group
import com.nvozhegov.optimalworkout.data.model.entity.Template
import com.nvozhegov.optimalworkout.data.model.entity.TemplatesExercises
import com.nvozhegov.optimalworkout.data.model.entity.WorkoutTemplate

@Database(entities = [
    Exercise::class,
    Group::class,
    WorkoutTemplate::class,
    Template::class,
    TemplatesExercises::class],
    version = 1,
    exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun exerciseDao(): ExerciseDao
    abstract fun groupDao(): GroupDao
    abstract fun workoutTemplateDao(): WorkoutTemplateDao
    abstract fun templateDao(): TemplateDao
}