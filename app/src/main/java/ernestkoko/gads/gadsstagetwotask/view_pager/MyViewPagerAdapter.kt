package ernestkoko.gads.gadsstagetwotask.view_pager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class MyViewPagerAdapter(
    val list: ArrayList<Fragment>,
    fragManager: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fragManager, lifecycle) {
    //list of fragment
   val  fragmentList = list
    override fun getItemCount(): Int {
        //return the size of the list of fragment
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        //return the fragment at a specified position
        return fragmentList[position]
    }
}