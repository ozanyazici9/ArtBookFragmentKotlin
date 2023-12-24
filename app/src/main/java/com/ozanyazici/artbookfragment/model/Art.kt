package com.ozanyazici.artbookfragment.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Art(

    @ColumnInfo(name = "artName")
    var artName: String,

    @ColumnInfo(name = "artistName")
    var artistName: String?,

    @ColumnInfo(name = "year")
    var year: String?,

    @ColumnInfo(name = "image")
    var image: ByteArray?

) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}