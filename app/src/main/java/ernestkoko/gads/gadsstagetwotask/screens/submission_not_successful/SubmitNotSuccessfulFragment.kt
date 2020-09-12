package ernestkoko.gads.gadsstagetwotask.screens.submission_not_successful

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import ernestkoko.gads.gadsstagetwotask.R


class SubmitNotSuccessfulFragment : DialogFragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_submit_not_successful, container, false)
    }


}