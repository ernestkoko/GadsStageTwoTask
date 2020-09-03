package ernestkoko.gads.gadsstagetwotask.services

import ernestkoko.gads.gadsstagetwotask.models.LearnerLeaders
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface LeaderService {
    @GET("api/hours")
    fun getLearningLeaders(): Call<List<LearnerLeaders>>
}