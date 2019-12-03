package com.example.jokerfinder.remote.movieFinderApi

import com.example.jokerfinder.models.Credits
import com.example.jokerfinder.models.ResponseDetailMovie
import com.example.jokerfinder.models.ResponseSearchMovieModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface MovieFinderApi {

    @GET("search/movie")
    fun getMovieDetailSearched(@Query("api_key") apiKey : String , @Query("query") query: String) : Observable<ResponseSearchMovieModel>

    @GET("movie/{movie_id}")
    fun getMovieDetails(@Path("movie_id")movieId : Int, @Query("api_key") apiKey : String ) : Observable<ResponseDetailMovie>

    @GET("movie/{movie_id}/credits")
    fun getCastsOfMovies(@Path("movie_id")movieId: Int, @Query("api_key") apiKey: String) : Observable<Credits>
}