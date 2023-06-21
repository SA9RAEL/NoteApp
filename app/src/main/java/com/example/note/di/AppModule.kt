package com.example.note.di

import android.app.Application
import androidx.room.Room
import com.example.note.feature_note.data.data_source.NoteDatabase
import com.example.note.feature_note.data.data_source.NoteDatabase.Companion.DB_NAME
import com.example.note.feature_note.data.repository.NoteRepositoryImpl
import com.example.note.feature_note.domain.repository.NoteRepository
import com.example.note.feature_note.domain.use_case.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase =
        Room.databaseBuilder(
        app,
        NoteDatabase::class.java,
        DB_NAME
    ).build()

    @Provides
    @Singleton
    fun provideNoteRepository(database: NoteDatabase): NoteRepository =
        NoteRepositoryImpl(database.noteDao)

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases =
        NoteUseCases(
            getNotesUseCase = GetNotesUseCase(repository),
            deleteNoteUseCase = DeleteNoteUseCase(repository),
            addNoteUseCase = AddNoteUseCase(repository),
            getNoteUseCase = GetNoteUseCase(repository)
        )
}