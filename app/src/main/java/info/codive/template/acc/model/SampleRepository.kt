package info.codive.template.acc.model

import androidx.lifecycle.LiveData
import info.codive.template.acc.model.data.SampleEntity
import info.codive.template.acc.model.database.SampleTableDao

/**
 * Repositoryを利用しデータソースを隠蔽する。
 * Roomに値が保存されていない場合はAPIからデータを取得、
 * Roomに値が保存されていて、かつ最後に取得した日時から１時間過ぎていればAPIからデータを取得する、
 * それ以外の場合はRoomから値を取得するなど。
 * APIから取得した場合はRoomにまず保存し、その後RoomからLiveData(Paging)を返す。
 */
class SampleRepository(
    private val mDao: SampleTableDao
) {
    fun getAll(): LiveData<List<SampleEntity>> {
//        Log.i("REPOSITORY", "Thread Name = " + Thread.currentThread().name)
        return mDao.getAllLiveData()
    }

//    @WorkerThread
//    suspend fun get(id: Long): SampleEntity {
//        Log.i("REPOSITORY", "Thread Name = " + Thread.currentThread().name)
//        return mDao.get(id) ?: SampleEntity()
//    }
//
//    @WorkerThread
//    suspend fun insertOrUpdate(itemEntity: SampleEntity) {
//        Log.i("REPOSITORY", "Thread Name = " + Thread.currentThread().name)
//        val rowId = mDao.insert(itemEntity)
//        Log.i(this.javaClass.simpleName, "Insert RowID = $rowId")
//    }
//
//    @WorkerThread
//    suspend fun update(itemEntity: SampleEntity) {
//        Log.i("REPOSITORY", "Thread Name = " + Thread.currentThread().name)
//        val count = mDao.update(itemEntity)
//        Log.i(this.javaClass.simpleName, "Update Count = $count")
//    }
//
//    @WorkerThread
//    suspend fun delete(sampleEntity: SampleEntity) {
//        Log.i("REPOSITORY", "Thread Name = " + Thread.currentThread().name)
//        var count = mDao.delete(sampleEntity)
//        Log.i(this.javaClass.simpleName, "Delete Count = $count")
//    }
//
//    @WorkerThread
//    suspend fun deleteAll() {
//        Log.i("REPOSITORY", "Thread Name = " + Thread.currentThread().name)
//        mDao.deleteAll()
//    }
}