package ernestkoko.gads.gadsstagetwotask.screens.skilliq_leaders


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ernestkoko.gads.gadsstagetwotask.R
import ernestkoko.gads.gadsstagetwotask.databinding.FragmentLearningLeaderBinding
import ernestkoko.gads.gadsstagetwotask.models.SkillIqLeadersModel
import ernestkoko.gads.gadsstagetwotask.services.LeaderService
import ernestkoko.gads.gadsstagetwotask.services.ServiceBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LearningLeaderFragment : Fragment() {
    private lateinit var mBinding: FragmentLearningLeaderBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_learning_leader, container, false)
        val adapter = SkillIqRecyclerViewAdapter()
        mBinding.learnerLeadersSkillRecyclerView.adapter = adapter
        mBinding.learnerLeadersSkillRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)

        val service = ServiceBuilder.buildService(LeaderService::class.java)
        val call = service.getLearnerLeadersSkillIq()
        call.enqueue(object : Callback<List<SkillIqLeadersModel>> {
            override fun onResponse(
                call: Call<List<SkillIqLeadersModel>>,
                response: Response<List<SkillIqLeadersModel>>
            ) {
                Log.v("IQFrag", response.body().toString())
                adapter.submitList(response.body())
            }

            override fun onFailure(call: Call<List<SkillIqLeadersModel>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })


        return mBinding.root
    }
}