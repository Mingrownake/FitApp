package com.nvozhegov.optimalworkout.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("templates")
data class Template(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val title: String
)
