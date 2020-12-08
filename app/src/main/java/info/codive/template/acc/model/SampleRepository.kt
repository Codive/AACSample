package info.codive.template.acc.model

import androidx.lifecycle.LiveData
import info.codive.template.acc.model.data.SampleEntity
import info.codive.template.acc.model.database.SampleTableDao

class SampleRepository(
    private val mDao: SampleTableDao
) {
    fun getAll(): LiveData<List<SampleEntity>> {
        return mDao.getAllLiveData()
    }
}