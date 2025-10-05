package com.nvozhegov.optimalworkout.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nvozhegov.optimalworkout.data.dao.ExerciseDao
import com.nvozhegov.optimalworkout.data.database.AppDatabase
import com.nvozhegov.optimalworkout.data.repository.ExerciseRepositoryImpl
import com.nvozhegov.optimalworkout.domain.exercise.ExerciseRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface ExerciseModule {

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

    @Singleton
    @Provides
    fun provideExerciseDao(
        database: AppDatabase
    ): ExerciseDao {
        return database.exerciseDao()
    }

    @Binds
    fun bindExerciseRepository(
        impl: ExerciseRepositoryImpl
    ): ExerciseRepository
}