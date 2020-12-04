package info.codive.template.acc.view.sampleview

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import info.codive.template.acc.model.SampleRepository

class SampleViewModelFactory(private val repository: SampleRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SampleViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return SampleViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
