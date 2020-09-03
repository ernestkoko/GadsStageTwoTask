package ernestkoko.gads.gadsstagetwotask

import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.forEach
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import ernestkoko.gads.gadsstagetwotask.databinding.FragmentLeaderBoardBinding
import ernestkoko.gads.gadsstagetwotask.models.LearnerLeaders
import ernestkoko.gads.gadsstagetwotask.services.LeaderService
import ernestkoko.gads.gadsstagetwotask.services.ServiceBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LeaderBoardFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LeaderBoardFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var mBinding: FragmentLeaderBoardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_leader_board, container, false)

        //get the nav controller
        val navController = findNavController()
        //get the toolbar
        val toolBar = mBinding.leaderboardToolBar
        //set the tool bar up with the nav controller
        toolBar.setupWithNavController(navController)
        val menu = toolBar.menu
        menu.forEach { menuItem ->
            if (menuItem.itemId == R.id.submit){
                menuItem.actionView.background = Resources.getSystem().getDrawable(R.drawable.ic_launcher_background)

            }

        }

        val service = ServiceBuilder.buildService(LeaderService::class.java)
        val call = service.getLearningLeaders()
        call.enqueue(object : Callback<List<LearnerLeaders>> {
            override fun onResponse(
                call: Call<List<LearnerLeaders>>,
                response: Response<List<LearnerLeaders>>
            ) {
                mBinding

            }

            override fun onFailure(call: Call<List<LearnerLeaders>>, t: Throwable) {
            }


        })


        return mBinding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LeaderBoardFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LeaderBoardFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}