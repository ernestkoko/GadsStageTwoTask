package ernestkoko.gads.gadsstagetwotask.screens.skilliq_leaders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ernestkoko.gads.gadsstagetwotask.databinding.SkillIqItemViewBinding
import ernestkoko.gads.gadsstagetwotask.models.SkillIqLeadersModel

class SkillIqRecyclerViewAdapter() :
    ListAdapter<SkillIqLeadersModel, SkillIqRecyclerViewAdapter.SkillIqViewHolder>(SKillIqDiffCallBack()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkillIqViewHolder {
        return  SkillIqViewHolder.from(parent)

    }

    override fun onBindViewHolder(holder: SkillIqViewHolder, position: Int) {
        holder.bind(getItem(position))

    }

    class SkillIqViewHolder private constructor(val binding: SkillIqItemViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(skillIqModel: SkillIqLeadersModel) {
            //bind the product
            binding.skillIqLeader = skillIqModel
            //execute any pending binding
            binding.executePendingBindings()

        }
        companion object{
            fun from(parent: ViewGroup): SkillIqViewHolder{
                //get a layout inflater
                val inflater = LayoutInflater.from(parent.context)
                val binding =  SkillIqItemViewBinding.inflate(inflater,parent,false)
                return SkillIqViewHolder(binding)


            }
        }

    }
}

class SKillIqDiffCallBack: DiffUtil.ItemCallback<SkillIqLeadersModel>() {
    override fun areItemsTheSame(
        oldItem: SkillIqLeadersModel,
        newItem: SkillIqLeadersModel
    ): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(
        oldItem: SkillIqLeadersModel,
        newItem: SkillIqLeadersModel
    ): Boolean {
        return oldItem == newItem
    }

}
