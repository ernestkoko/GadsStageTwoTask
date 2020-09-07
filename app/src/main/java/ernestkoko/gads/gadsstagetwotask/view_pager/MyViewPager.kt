package ernestkoko.gads.gadsstagetwotask.view_pager



import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import com.google.android.material.tabs.TabLayoutMediator
import ernestkoko.gads.gadsstagetwotask.screens.learning_leaders.LeaderBoardFragment
import ernestkoko.gads.gadsstagetwotask.R
import ernestkoko.gads.gadsstagetwotask.screens.skilliq_leaders.LearningLeaderFragment
import kotlinx.android.synthetic.main.custom_tool_bar.view.*

import kotlinx.android.synthetic.main.fragment_my_view_pager.view.*
import kotlin.collections.ArrayList

class MyViewPager : Fragment() {
    private lateinit var mListOfFragment: ArrayList<Fragment>



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_my_view_pager, container, false)
        fragmentList()
        val adapter =  MyViewPagerAdapter(mListOfFragment, requireActivity().supportFragmentManager, lifecycle)

        val pager = view.my_view_pager
        val pagerTabLayout = view.pager_tabLayout
        pager.adapter = adapter

        TabLayoutMediator(pagerTabLayout, pager){tab, position ->
            tab.text = "${when(position){
                0 -> resources.getString(R.string.learning_leaders)
                   
                1 -> resources.getString(R.string.skill_iq_leaders)
                   
                else -> "Not sure"
            }
            }"
        }.attach()

        view.submit_button.setOnClickListener {
            it.findNavController().navigate(R.id.action_myViewPager_to_submissionFragment)
           // Toast.makeText(requireContext(), "SubmitClicked", Toast.LENGTH_LONG).show()
        }




        return  view
    }

    private fun fragmentList(){
        mListOfFragment = arrayListOf(
            LeaderBoardFragment(),
            LearningLeaderFragment(),
        )
    }




}