package ernestkoko.gads.gadsstagetwotask.screens.submit

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ernestkoko.gads.gadsstagetwotask.services.LeaderService
import ernestkoko.gads.gadsstagetwotask.services.ServiceBuilder
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import java.io.IOException

class SubmissionViewModel : ViewModel() {
    private  val TAG = "SubmitViewModel"


    var firstName = MutableLiveData<String?>()
        set(value) {
            firstName.value = value.value
        }
    var lastName = MutableLiveData<String?>()
        set(value) {
            lastName.value = value.value
        }
    var email = MutableLiveData<String?>()
        set(value) {
            email.value = value.value
        }
    var githubLink = MutableLiveData<String?>()
        set(value) {
            githubLink.value = value.value
        }
    private var _isFieldEmpty = MutableLiveData<Boolean>()
    val isFieldEmpty: LiveData<Boolean>
        get() = _isFieldEmpty
    private var _isValidEmail = MutableLiveData<Boolean>()
    val isValidEmail: LiveData<Boolean>
        get() = _isValidEmail
    private var _popUpAreYouSureFragment = MutableLiveData<Boolean>()
    val popUpAreYouSureFragment: LiveData<Boolean>
        get() = _popUpAreYouSureFragment

    private var  _showSuccessDialog = MutableLiveData<Boolean>()
    val showSuccessDialog: LiveData<Boolean>
    get() = _showSuccessDialog
    private var _showFailureDialog = MutableLiveData<Boolean>()
    val showFailureDialog: LiveData<Boolean>
    get() = _showFailureDialog

    /**
     * fun that is called when the submit button is clicked
     */
    fun onSubmitButtonClicked() {
        //check if the fields are empty
        if (!firstName.value?.trim().isNullOrEmpty() && !lastName.value?.trim()
                .isNullOrEmpty() && !email.value?.trim()
                .isNullOrEmpty() && !githubLink.value?.trim().isNullOrEmpty()
        ) {
            //no field is empty
            _isFieldEmpty.value = false
            //check if the email is correct email address
            if (isValidEmail(email.value!!.trim())) {
                //email is acceptable
                _isValidEmail.value = true
                //pop up Are you sure fragment
                _popUpAreYouSureFragment.value = true
                //show progress dialog

                //submit
                val service = ServiceBuilder.submitBuilderService(LeaderService::class.java)
                val call = service.submitForm(
                    firstName.value.toString(), lastName.value.toString(),email.value.toString(),githubLink.value.toString())
                call.enqueue( object:   retrofit2.Callback<Void> {
                    override fun onResponse(
                        call: retrofit2.Call<Void>,
                        response: retrofit2.Response<Void>
                    ) {

                        if (response.isSuccessful){
                            //show the success dialog
                            Log.i(TAG,"Submit: Successful")
                            Log.i(TAG, response.message().toString())
                            _showSuccessDialog.value = true

                        }

                    }

                    override fun onFailure(call: retrofit2.Call<Void>, t: Throwable) {
                        //show the failure dialog
                        _showFailureDialog.value = true
                        Log.i(TAG,"Submit: Not Successful")

                    }
                })


            } else {
                //email is not valid
                _isValidEmail.value = false
                _popUpAreYouSureFragment.value = false
            }
        } else {
            //all or any of the fields are/is empty
            _isFieldEmpty.value = true
            _popUpAreYouSureFragment.value = false
        }

    }

    /**
     * @param email is the email to validate
     * returns true if the email meets required email standard
     */
    private fun isValidEmail(email: CharSequence): Boolean {
        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        //returns true if email is not empty and it matches standard ema?il format
        return email.matches(emailPattern.toRegex())

    }
}