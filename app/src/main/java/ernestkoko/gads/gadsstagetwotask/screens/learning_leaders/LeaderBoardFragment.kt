package ernestkoko.gads.gadsstagetwotask.screens.learning_leaders

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
import ernestkoko.gads.gadsstagetwotask.databinding.FragmentLeaderBoardBinding
import ernestkoko.gads.gadsstagetwotask.models.LearnerLeadersModel
import ernestkoko.gads.gadsstagetwotask.services.LeaderService
import ernestkoko.gads.gadsstagetwotask.services.ServiceBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LeaderBoardFragment : Fragment() {

    private lateinit var mBinding: FragmentLeaderBoardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_leader_board, container, false)
        mBinding.learningRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)

        val adapter = LearningLeadersRecyclerViewAdapter()
        mBinding.learningRecyclerView.adapter = adapter
        val service = ServiceBuilder.buildService(LeaderService::class.java)
        val call = service.getLearningLeaders()
        call.enqueue(object : Callback<List<LearnerLeadersModel>> {
            override fun onResponse(
                call: Call<List<LearnerLeadersModel>>,
                response: Response<List<LearnerLeadersModel>>
            ) {
                Log.v("LeaderFrag", response.body().toString())
                adapter.submitList(response.body())

            }

            override fun onFailure(call: Call<List<LearnerLeadersModel>>, t: Throwable) {
                Log.i("Leader", t.message.toString())
            }


        })


        return mBinding.root
    }
}