package info.codive.template.acc.view.sampleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import info.codive.template.acc.R
import info.codive.template.acc.model.data.SampleEntity
import java.text.SimpleDateFormat

class SampleRecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val id: TextView = view.findViewById<TextView>(R.id.id)
    private val message: TextView = view.findViewById<TextView>(R.id.message)
    private val uri: TextView = view.findViewById<TextView>(R.id.uri)
    private val update: TextView = view.findViewById<TextView>(R.id.update)
    private val create: TextView = view.findViewById<TextView>(R.id.create)
    private val dateFormat = SimpleDateFormat("yyyy/MM/dd HH:mm")

    fun bind(currentSampleEntity: SampleEntity) {
        id.text = currentSampleEntity.id.toString()
        message.text = currentSampleEntity.message
        uri.text = currentSampleEntity.uri.toString()
        update.text = dateFormat.format(currentSampleEntity.updateDate)
        create.text = dateFormat.format(currentSampleEntity.createDate)
    }

    companion object {
        fun from(parent: ViewGroup): SampleRecyclerViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val view = layoutInflater.inflate(R.layout.view_item, parent, false)

            val id = view.findViewById<TextView>(R.id.id)
            view.setOnClickListener {
                Toast.makeText(parent.context, "position ${id.text} was tapped", Toast.LENGTH_SHORT)
                    .show()
            }
            return SampleRecyclerViewHolder(view)
        }
    }
}
