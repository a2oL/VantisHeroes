package mx.org.aad.vantisheroes.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://rickandmortyapi.com/api/character/"

private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(BASE_URL)
        .build()

interface RickApiService {
    @GET("1,2,3,4,5,6,9,10,11,12,13,14,15,16,17,18")
    suspend fun getProperties(): List<RickProperty>
}

object RickApi {
    val retrofitService : RickApiService by lazy { retrofit.create(RickApiService::class.java) }
}
