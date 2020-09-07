package ernestkoko.gads.gadsstagetwotask.util

import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import ernestkoko.gads.gadsstagetwotask.R
import ernestkoko.gads.gadsstagetwotask.models.LearnerLeadersModel
import ernestkoko.gads.gadsstagetwotask.models.SkillIqLeadersModel

@BindingAdapter("learningLeaderName")
fun TextView.setLearnerLeaderName(leader:LearnerLeadersModel?){
    leader?.let {
        text = leader.name
    }
}
@BindingAdapter("learningLeaderHours")
fun TextView.setLearnerleaderHours(leader: LearnerLeadersModel?){
    leader?.let {
        text = leader.hours.toString() + " ${resources.getString(R.string.learning_hours)}, ${ leader.country}"
    }
}
@BindingAdapter("learningLeaderImageUrl")
fun loadLearningLeaderImageUrl(view: ImageView, url: String){
    if (url.isNullOrEmpty()){

        Picasso.get().load(url)
            .error(R.drawable.top_learner)
            .placeholder(R.drawable.top_learner).fit().centerCrop().into(view)

    }
}

@BindingAdapter("SkillIqLeaderImageUrl")
fun loadSKillIqLeaderImageUrl(view: ImageView, url: String){
    if (url.isNullOrEmpty()){

        Picasso.get().load(url)
            .error(R.drawable.top_learner)
            .placeholder(R.drawable.top_learner).fit().centerCrop().into(view)

    }
}
@BindingAdapter("skillLeaderScore")
fun TextView.setSkillLeaderScore(leader: SkillIqLeadersModel?){
    leader?.let {
        text = leader.score.toString() + " ${resources.getString(R.string.skill_iq_score)}, ${ leader.country}"
    }
}
@BindingAdapter("skillLeaderName")
fun TextView.setSkillLeaderName(leader:SkillIqLeadersModel?){
    leader?.let {
        text = leader.name
    }
}

