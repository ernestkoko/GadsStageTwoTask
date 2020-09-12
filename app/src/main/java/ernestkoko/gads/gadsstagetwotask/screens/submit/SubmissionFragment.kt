package ernestkoko.gads.gadsstagetwotask.screens.submit

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import ernestkoko.gads.gadsstagetwotask.R
import ernestkoko.gads.gadsstagetwotask.databinding.CustomToolbar2Binding
import ernestkoko.gads.gadsstagetwotask.databinding.SubmissionFragmentBinding
import ernestkoko.gads.gadsstagetwotask.screens.are_you_sure.AreYouSureFragment
import ernestkoko.gads.gadsstagetwotask.screens.submission_not_successful.SubmitNotSuccessfulFragment
import ernestkoko.gads.gadsstagetwotask.screens.submission_successful.SubmitSuccessfulFragment
import kotlinx.android.synthetic.main.custom_toolbar2.*
import kotlinx.android.synthetic.main.custom_toolbar2.view.*

class SubmissionFragment : Fragment(), AreYouSureFragment.OnYesClicked {
    private lateinit var mBinding : SubmissionFragmentBinding
    private val TAG = "SubmitFragment"
    private lateinit var mYesDialog: AreYouSureFragment
    private var mYes = false
    private var myes = MutableLiveData<Boolean>()




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

        //observe when to pop up Are you sure fragment
        viewModel.popUpAreYouSureFragment.observe( viewLifecycleOwner, Observer {
            if (it){
                Log.i(TAG, "PopUp: AReYouSure")
                 mYesDialog = AreYouSureFragment()
                mYesDialog.setTargetFragment(this, 300)
                mYesDialog.show(parentFragmentManager,"AreYouSureDialog")


            }
        })

        //observe when the email does not meet format
        viewModel.isValidEmail.observe(viewLifecycleOwner, Observer {
            if (!it){
                //set an error message when the format of the email does not meet the standard
                mBinding.emailAddress.error = resources.getString(R.string.input_correct_email_format)
            }else{
                //clear the error if the format of the email meets the standard
                mBinding.emailAddress.error = null
            }

        })

        myes.observe(viewLifecycleOwner, Observer {
            if (it){
                Log.i(TAG, "LiveData:" +myes.value)
                if (mYesDialog.isVisible){
                    mYesDialog.dismiss()
                }
                //trigger the submit method
                viewModel.onSubmitButtonClicked()

//                val submitDialog = SubmitNotSuccessfulFragment()
//                submitDialog.show(parentFragmentManager,"SubmitSuccessful")
            }
        })

        //observe when to pop up the success fragment
        viewModel.showSuccessDialog.observe(viewLifecycleOwner, Observer {
            if (it){
                if (mYesDialog.isVisible){
                    mYesDialog.dismiss()
                }
                //pop up the success dialog
                val successDialog = SubmitSuccessfulFragment()
                successDialog.show(parentFragmentManager, "SuccessDialog")
            }
        })
        //observe when to pop up failure dialog
        viewModel.showFailureDialog.observe(viewLifecycleOwner, Observer {
            if (it){
                if (mYesDialog.isVisible){
                    mYesDialog.dismiss()
                }

                //pop up failure dialog
               val failureDialog = SubmitNotSuccessfulFragment()
                failureDialog.show(parentFragmentManager,"FailureDialog")
            }
         })

        //navigate back when the back arrow is clicked
//        mBinding.root.nav_back_icon.setOnClickListener {
//            findNavController().navigate(R.id.action_submissionFragment_to_myViewPager)
//        }submitToolbar2.navBackIcon as ImageView
        val view = mBinding.root.findViewById<ImageView>(R.id.nav_back_icon)
        view.setOnClickListener {
            findNavController().navigate(R.id.action_submissionFragment_to_myViewPager)
        }








        return mBinding.root

    }

    override fun yesClicked(yes: Boolean) {
        Log.i(TAG, "yesClicked: "+yes.toString())
        myes.value = yes

    }


}