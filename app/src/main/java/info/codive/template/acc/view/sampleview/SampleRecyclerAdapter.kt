package info.codive.template.acc.view.sampleview

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import info.codive.template.acc.model.data.SampleEntity

class SampleRecyclerAdapter() : ListAdapter<Any, RecyclerView.ViewHolder>(ItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return SampleRecyclerViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        (holder as SampleRecyclerViewHolder).bind(item as SampleEntity)
    }
}

/**
 * 差分チェック
 */
class ItemDiffCallback : DiffUtil.ItemCallback<Any>() {
    //2つのアイテム自体が同じものであるかを判定します。
    override fun areItemsTheSame(oldEntity: Any, newEntity: Any): Boolean {
        return if (oldEntity is SampleEntity && newEntity is SampleEntity) {
            oldEntity.id == newEntity.id
        } else {
            false
        }
    }

    //2つのアイテムのデータ内容が同じであるかを判定します。 falseを返す場合Viewが再利用されます。
    // このメソッドはareItemsTheSameがtrueを返す場合にのみ呼ばれます。
    override fun areContentsTheSame(oldEntity: Any, newEntity: Any): Boolean {
        return if (oldEntity is SampleEntity && newEntity is SampleEntity) {
            oldEntity.updateDate == newEntity.updateDate
        } else {
            false
        }
    }
}