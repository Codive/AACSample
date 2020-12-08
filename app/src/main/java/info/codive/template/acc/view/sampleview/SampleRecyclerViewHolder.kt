package info.codive.template.acc.view.sampleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import info.codive.template.acc.databinding.ViewItemBinding
import info.codive.template.acc.model.data.SampleEntity
import java.text.SimpleDateFormat

class SampleRecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ViewItemBinding.bind(view)
    private val dateFormat = SimpleDateFormat("yyyy/MM/dd HH:mm")

    fun bind(currentSampleEntity: SampleEntity) {
        binding.id.text = currentSampleEntity.id.toString()
        binding.message.text = currentSampleEntity.message
        binding.uri.text = currentSampleEntity.uri.toString()
        binding.update.text = dateFormat.format(currentSampleEntity.updateDate)
        binding.create.text = dateFormat.format(currentSampleEntity.createDate)
    }

    companion object {
        fun from(parent: ViewGroup): SampleRecyclerViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ViewItemBinding.inflate(layoutInflater)

            binding.root.setOnClickListener {
                Toast.makeText(
                    parent.context,
                    "position ${binding.id.text} was tapped",
                    Toast.LENGTH_SHORT
                )
                    .show()
            }
            return SampleRecyclerViewHolder(binding.root)
        }
    }
}
