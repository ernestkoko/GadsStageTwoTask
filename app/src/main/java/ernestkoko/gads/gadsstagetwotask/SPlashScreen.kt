package ernestkoko.gads.gadsstagetwotask

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import ernestkoko.gads.gadsstagetwotask.databinding.FragmentSPlashScreenBinding


class SPlashScreen : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentSPlashScreenBinding>(inflater, R.layout.fragment_s_plash_screen, container, false)

        Handler().postDelayed({
            findNavController().navigate(R.id.action_SPlashScreen_to_myViewPager)

        }, 3000)
        return binding.root

    }


}