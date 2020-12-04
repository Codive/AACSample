package info.codive.template.acc.view.sampleview

import androidx.lifecycle.ViewModel
import info.codive.template.acc.model.SampleRepository

class SampleViewModel(    private val repository: SampleRepository) : ViewModel() {
    val sampleArray = repository.getAll()
}