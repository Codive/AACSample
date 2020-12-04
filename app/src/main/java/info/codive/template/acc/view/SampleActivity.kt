package info.codive.template.acc.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import info.codive.template.acc.R
import info.codive.template.acc.model.SampleRepository
import info.codive.template.acc.view.sampleview.SampleRecyclerAdapter
import info.codive.template.acc.view.sampleview.SampleViewModel
import info.codive.template.acc.view.sampleview.SampleViewModelFactory
import info.codive.template.acc.model.database.SampleDatabase

class SampleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample)

        val sampleTableDao = SampleDatabase.getInstance(this).sampleTableDao
        val repository = SampleRepository(sampleTableDao)
        val viewModelFactory = SampleViewModelFactory(repository)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(SampleViewModel::class.java)

        val sampleRecyclerView = findViewById<RecyclerView>(R.id.sample_recycler_view)
        val adapter = SampleRecyclerAdapter()
        sampleRecyclerView.adapter = adapter
        val itemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        sampleRecyclerView.addItemDecoration(itemDecoration)

        viewModel.sampleArray.observe(this) {
            adapter.submitList(it)
        }
    }
}