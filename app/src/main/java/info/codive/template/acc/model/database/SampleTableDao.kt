package info.codive.template.acc.model.database

import androidx.lifecycle.LiveData
import androidx.room.*
import info.codive.template.acc.model.data.SampleEntity

@Dao
interface SampleTableDao {
    @Query("SELECT * from sample_table WHERE id = :id")
    fun get(id: Long): SampleEntity?

    @Query("SELECT * from sample_table ORDER BY id DESC")
    fun getAll(): LiveData<List<SampleEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE) //衝突した場合は上書き
    fun insert(itemEntity: SampleEntity): Long

    @Update
    fun update(itemEntity: SampleEntity): Int

    @Delete
    fun delete(itemEntity: SampleEntity): Int

    @Query("DELETE FROM sample_table")
    fun deleteAll(): Int
}