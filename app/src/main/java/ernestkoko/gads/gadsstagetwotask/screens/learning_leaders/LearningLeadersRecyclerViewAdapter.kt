package ernestkoko.gads.gadsstagetwotask.screens.learning_leaders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ernestkoko.gads.gadsstagetwotask.databinding.LearningLeadersItemViewBinding
import ernestkoko.gads.gadsstagetwotask.models.LearnerLeadersModel

class LearningLeadersRecyclerViewAdapter :
    ListAdapter<LearnerLeadersModel, LearningLeadersRecyclerViewAdapter.LearningLeaderViewHolder>(LearnersLeadersDiffCallback()) {



    class LearningLeaderViewHolder private constructor(val binding: LearningLeadersItemViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(learnLeaders: LearnerLeadersModel) {
            binding.learningLeader = learnLeaders
            binding.executePendingBindings()
        }

        companion object {
            fun from(root: ViewGroup): LearningLeaderViewHolder {
                //get the layout inflater
                val inflater = LayoutInflater.from(root.context)
                val binding = LearningLeadersItemViewBinding.inflate(inflater, root, false)
                return LearningLeaderViewHolder(binding)
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LearningLeaderViewHolder {
        return LearningLeaderViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: LearningLeaderViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class LearnersLeadersDiffCallback : DiffUtil.ItemCallback<LearnerLeadersModel>() {
    override fun areItemsTheSame(
        oldItem: LearnerLeadersModel,
        newItem: LearnerLeadersModel
    ): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(
        oldItem: LearnerLeadersModel,
        newItem: LearnerLeadersModel
    ): Boolean {
       return oldItem == newItem
    }

}