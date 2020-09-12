package ernestkoko.gads.gadsstagetwotask.services


import ernestkoko.gads.gadsstagetwotask.models.LearnerLeadersModel
import ernestkoko.gads.gadsstagetwotask.models.SkillIqLeadersModel
import ernestkoko.gads.gadsstagetwotask.models.SubmitButtonResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST


interface LeaderService {
    @GET("api/hours")
    fun getLearningLeaders(): Call<List<LearnerLeadersModel>>
    @GET("api/skilliq")
    fun getLearnerLeadersSkillIq(): Call<List<SkillIqLeadersModel>>

    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    @FormUrlEncoded
    fun submitForm(
        @Field("entry.1877115667") name: String,
        @Field("entry.2006916086") lastname: String,
        @Field("entry.1824927963") emailaddress: String,
        @Field("entry.284483984") linktoproject: String
    ): Call<Void>

    @FormUrlEncoded
    @POST("auth/login")
    fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<SubmitButtonResponse>

}