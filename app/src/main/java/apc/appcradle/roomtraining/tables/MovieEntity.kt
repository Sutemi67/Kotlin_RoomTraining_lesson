package apc.appcradle.roomtraining.tables

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.ColumnInfo.Companion.TEXT
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "movie_table")
data class MovieEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "movie_id")
    val id: Long,
    @ColumnInfo(name = "movie_name", typeAffinity = TEXT)
    val title: String,
    val description: String,
    @Ignore
    val image: Bitmap?
) {
    constructor(id: Long, title: String, description: String) : this(
        id,
        title,
        description,
        image = null
    )
}