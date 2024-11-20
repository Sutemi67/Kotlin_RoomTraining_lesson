package apc.appcradle.roomtraining.tables

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "actor_table")
data class ActorEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    @ColumnInfo(name = "actor_name", typeAffinity = ColumnInfo.TEXT)
    val name: String
)
