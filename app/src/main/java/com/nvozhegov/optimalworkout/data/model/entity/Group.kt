package com.nvozhegov.optimalworkout.data.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "groups")
data class Group(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "group_id")
    val id: Int,
    @ColumnInfo(name = "name")
    val name: String
)
