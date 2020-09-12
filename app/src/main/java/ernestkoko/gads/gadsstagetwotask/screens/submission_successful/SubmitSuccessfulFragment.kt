package ernestkoko.gads.gadsstagetwotask.screens.submission_successful

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import ernestkoko.gads.gadsstagetwotask.R
import ernestkoko.gads.gadsstagetwotask.databinding.FragmentSubmitSuccessfulBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class SubmitSuccessfulFragment : DialogFragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentSubmitSuccessfulBinding>(
            inflater,
            R.layout.fragment_submit_successful,
            container,
            false
        )
        return binding.root
    }

}