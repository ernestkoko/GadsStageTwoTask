package ernestkoko.gads.gadsstagetwotask.submit

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ernestkoko.gads.gadsstagetwotask.R
import ernestkoko.gads.gadsstagetwotask.databinding.SubmissionFragmentBinding

class SubmissionFragment : Fragment() {
    private lateinit var mBinding : SubmissionFragmentBinding




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.submission_fragment, container, false)
        //initialise the viewModel
        val viewModel = ViewModelProvider(this).get(SubmissionViewModel::class.java)
        //connect the viewModel
        mBinding.submitViewModel = viewModel



        //observe when the fields are empty
        viewModel.isFieldEmpty.observe(viewLifecycleOwner, Observer {
            if (it){
                Toast.makeText(requireContext(), "Fill all the fields!", Toast.LENGTH_LONG).show()
                //observe when email is not valid
                viewModel.isValidEmail.observe(viewLifecycleOwner, Observer {
                    if (!it){
                        Toast.makeText(requireContext(), "Email is not valid", Toast.LENGTH_LONG).show()
                    }
                })
            }
        })

        return mBinding.root

    }


}