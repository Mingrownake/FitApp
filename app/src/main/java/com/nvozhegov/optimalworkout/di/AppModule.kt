package com.nvozhegov.optimalworkout.di

import android.content.Context
import androidx.room.Room
import com.nvozhegov.optimalworkout.data.dao.ExerciseDao
import com.nvozhegov.optimalworkout.data.dao.GroupDao
import com.nvozhegov.optimalworkout.data.dao.TemplateDao
import com.nvozhegov.optimalworkout.data.dao.WorkoutTemplateDao
import com.nvozhegov.optimalworkout.data.database.AppDatabase
import com.nvozhegov.optimalworkout.data.repository.ExerciseRepositoryImpl
import com.nvozhegov.optimalworkout.data.repository.TemplateRepositoryImpl
import com.nvozhegov.optimalworkout.data.repository.WorkoutTemplateRepositoryImpl
import com.nvozhegov.optimalworkout.domain.exercise.ExerciseRepository
import com.nvozhegov.optimalworkout.domain.template.TemplateRepository
import com.nvozhegov.optimalworkout.domain.workoutTemplate.WorkoutTemplateRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface AppModule {
    @Binds
    fun bindExerciseRepository(
        impl: ExerciseRepositoryImpl
    ): ExerciseRepository

    @Binds
    fun bindWorkoutTemplateRepository(
        impl: WorkoutTemplateRepositoryImpl
    ): WorkoutTemplateRepository

    @Binds
    fun bindTemplateRepository(
        impl: TemplateRepositoryImpl
    ): TemplateRepository

    companion object {
        @Singleton
        @Provides
        fun provideWorkoutTemplateDao(
            database: AppDatabase
        ): WorkoutTemplateDao {
            return database.workoutTemplateDao()
        }

        @Singleton
        @Provides
        fun provideGroupDao(
            database: AppDatabase
        ): GroupDao {
            return database.groupDao()
        }

        @Singleton
        @Provides
        fun provideTemplateDao(
            database: AppDatabase
        ): TemplateDao {
            return database.templateDao()
        }

        @Singleton
        @Provides
        fun provideExerciseDao(
            database: AppDatabase
        ): ExerciseDao {
            return database.exerciseDao()
        }

        @Singleton
        @Provides
        fun provideAppDatabase(
            @ApplicationContext context: Context
        ): AppDatabase {
            return Room.databaseBuilder<AppDatabase>(
                context = context,
                AppDatabase::class.java,
                name = "app_database"
            ).build()
        }
    }
}