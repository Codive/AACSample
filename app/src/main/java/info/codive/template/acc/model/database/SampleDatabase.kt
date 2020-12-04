package info.codive.template.acc.model.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import info.codive.template.acc.model.data.Converters
import info.codive.template.acc.model.data.SampleEntity
import java.util.*

const val DATABASE_NAME = "sample.db"

@Database(entities = [SampleEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class SampleDatabase : RoomDatabase() {
    abstract val sampleTableDao: SampleTableDao

    companion object {
        @Volatile
        private var INSTANCE: SampleDatabase? = null
        fun getInstance(context: Context): SampleDatabase {
            synchronized(this) {
                // ローカル変数にコピーすることでスマートキャストの機能を使えるようになる
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        SampleDatabase::class.java,
                        DATABASE_NAME
                    )
                        .addCallback(SampleCallback())
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                // スマートキャストの機能（ここではnullでないことを保証）
                return instance
            }
        }

        private class SampleCallback() : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                val sql = "INSERT INTO 'sample_table' VALUES " +
                        "(NULL, 'message1', '', ?, ?)," +
                        "(NULL, 'message2', '', ?, ?)," +
                        "(NULL, 'message3', '', ?, ?)"
                db.execSQL(
                    sql,
                    arrayOf<Any>(
                        Date().time, Date().time,
                        Date().time, Date().time,
                        Date().time, Date().time
                    )
                )
            }
        }
    }
}