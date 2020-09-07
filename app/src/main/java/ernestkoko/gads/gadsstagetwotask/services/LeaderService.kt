package ernestkoko.gads.gadsstagetwotask.services


import ernestkoko.gads.gadsstagetwotask.models.LearnerLeadersModel
import ernestkoko.gads.gadsstagetwotask.models.SkillIqLeadersModel
import retrofit2.Call
import retrofit2.http.GET


interface LeaderService {
    @GET("api/hours")
    fun getLearningLeaders(): Call<List<LearnerLeadersModel>>
    @GET("api/skilliq")
    fun getLearnerLeadersSkillIq(): Call<List<SkillIqLeadersModel>>
}