package com.nvozhegov.optimalworkout.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("templates")
data class Template(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "template_id")
    val templateId: Int,
    val title: String
)
