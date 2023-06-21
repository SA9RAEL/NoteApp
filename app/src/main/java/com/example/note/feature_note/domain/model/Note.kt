package com.example.note.feature_note.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.note.ui.theme.BabyBlue
import com.example.note.ui.theme.LightGreen
import com.example.note.ui.theme.RedOrange
import com.example.note.ui.theme.RedPink
import com.example.note.ui.theme.Violet


@Entity
data class Note(
    @PrimaryKey var id: Int? = null,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "content")
    val content: String,
    @ColumnInfo(name = "timestamp")
    val timestamp: Long,
    @ColumnInfo(name = "color")
    val color: Int
) {
    companion object {
        val noteColors = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink)
    }
}

class InvalidNoteException(message: String): Exception(message)