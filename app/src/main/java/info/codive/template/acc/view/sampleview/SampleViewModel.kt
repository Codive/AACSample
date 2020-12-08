package info.codive.template.acc.view.sampleview

import androidx.lifecycle.ViewModel
import info.codive.template.acc.model.SampleRepository

//Contextが必要な場合はAndroidViewModelを継承する
//class SampleAppViewModel(application: Application) : AndroidViewModel(application) {}
class SampleViewModel(    private val repository: SampleRepository) : ViewModel() {
    val sampleArray = repository.getAll()// MutableLiveData<List<SampleEntity>>()

//    fun getSampleArray(): LiveData<List<SampleEntity>> {
//        if (sampleArray.value == null) {
//            loadSampleArray()
//        }
//        return sampleArray
//    }
//
//    private fun loadSampleArray() {
//        // 非同期で本の情報を読み込み、MutableLiveData に反映する
//        viewModelScope.launch {
//            sampleArray.value = repository.getAll().value
//        }
//    }
}