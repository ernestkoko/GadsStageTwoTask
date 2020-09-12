package ernestkoko.gads.gadsstagetwotask.screens.are_you_sure

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import ernestkoko.gads.gadsstagetwotask.R
import ernestkoko.gads.gadsstagetwotask.databinding.FragmentAreYouSureBinding
import java.lang.ClassCastException


class AreYouSureFragment : DialogFragment() {
    private val TAG = "AReYouSure"
    private lateinit var mBinding: FragmentAreYouSureBinding
    private lateinit var mOnYesClicked: OnYesClicked



    interface OnYesClicked{
        fun yesClicked(yes: Boolean)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_are_you_sure, container, false)
        mBinding.yesText.setOnClickListener {
            Log.i(TAG, "Yes: Clicked")
            mOnYesClicked.yesClicked(true)
            dialog?.dismiss()


        }




        return mBinding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            mOnYesClicked = targetFragment as OnYesClicked
        }catch (e: ClassCastException){
            Log.i(TAG, "onAttached: ClassCastException ${e.cause}")
        }
    }

}