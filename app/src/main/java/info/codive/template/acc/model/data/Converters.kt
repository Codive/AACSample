package info.codive.template.acc.model.data

import android.net.Uri
import androidx.room.TypeConverter
import java.util.*

class Converters {
    @TypeConverter
    fun dateFromTimestamp(dateLong: Long): Date {
        return Date(dateLong)
    }

    @TypeConverter
    fun dateToTimestamp(date: Date): Long {
        return date.time
    }

    @TypeConverter
    fun uriFromString(uriStr: String): Uri {
        return Uri.parse(uriStr)
    }

    @TypeConverter
    fun uriToString(uri: Uri): String {
        return uri.toString()
    }
}