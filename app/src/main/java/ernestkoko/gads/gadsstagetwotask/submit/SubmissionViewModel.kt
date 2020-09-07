package ernestkoko.gads.gadsstagetwotask.submit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SubmissionViewModel : ViewModel() {


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

    /**
     * fun that is called when the submit button is clicked
     */
    fun onSubmitButtonClicked() {
        //check if the fields are empty
        if (!firstName.value?.trim().isNullOrEmpty() && !lastName.value?.trim()
                .isNullOrEmpty() && !email.value?.trim().isNullOrEmpty() && !githubLink.value?.trim().isNullOrEmpty()
        ) {
            //no field is empty
            _isFieldEmpty.value = false
            //check if the email is correct email address
            if (isValidEmail(email.value!!.trim())) {
                //email is acceptable
                _isValidEmail.value = true
            } else {
                //email is not valid
                _isValidEmail.value = false
            }
        } else {
            //all or any of the fields are/is empty
            _isFieldEmpty.value = true
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