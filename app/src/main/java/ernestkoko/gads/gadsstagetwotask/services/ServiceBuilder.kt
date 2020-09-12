package ernestkoko.gads.gadsstagetwotask.services

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
//base url
private val URL = "https://gadsapi.herokuapp.com/"
private val SUBMIT_BASE_URL = "https://docs.google.com/forms/d/e/"
class ServiceBuilder {
    companion object{
     //logger
     private val logger: HttpLoggingInterceptor =
         HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
     //create the http client
     private val okHttp = OkHttpClient.Builder().addInterceptor(logger)
     //get the retrofit builder
     private val builder = Retrofit.Builder().baseUrl(URL)
         .addConverterFactory(GsonConverterFactory.create())
         .client(okHttp.build())
        private val retrofit = builder.build()

        fun <T> buildService(service: Class<T>): T{
            return retrofit.create(service)
        }

        //get the retrofit for the submit
        private val submitBuilder = Retrofit.Builder().baseUrl(SUBMIT_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttp.build())
        private val submitRetrofit = submitBuilder.build()
        fun <T> submitBuilderService(service: Class<T>): T{
            return submitRetrofit.create(service)
        }



 }

}
