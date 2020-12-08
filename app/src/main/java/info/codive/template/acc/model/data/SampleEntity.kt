package info.codive.template.acc.model.data

import android.net.Uri
import androidx.room.*
import java.util.*

@Entity(tableName = "sample_table")
data class SampleEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long = 0L,
    @ColumnInfo(name = "message")
    var message: String = "sample",
    @ColumnInfo(name = "uri")
    var uri: Uri = Uri.EMPTY,
    @ColumnInfo(name = "update_date")
    var updateDate: Date = Date(),
    @ColumnInfo(name = "create_date")
    var createDate: Date = Date(),

//    @Ignore //Ignoreを使う場合は全て初期化するか、コンストラクターを書く必要がある
//    var isActive: Boolean = false,
)
