package ernestkoko.gads.gadsstagetwotask.models

import com.google.gson.annotations.SerializedName

data class LearnerLeadersModel(
 var name: String? = "",
 var hours: Int,
 var country: String,
 var badgeUrl: String
)

data class SkillIqLeadersModel(
 var name: String? = "",
 var score: Int? = 0,
 var country: String? = "",
 var badgeUrl: String? = ""
)
data class SubmitButtonResponse(
 @SerializedName("token") var token: String,
 @SerializedName("token_type") var token_type: String,
 @SerializedName("expires_in") var expires_in: Int,
 @SerializedName("user") var user: User
)

data class User(
 @SerializedName("id") val id: Int,
 @SerializedName("username") val username: String,
 @SerializedName("email") val email: String
)