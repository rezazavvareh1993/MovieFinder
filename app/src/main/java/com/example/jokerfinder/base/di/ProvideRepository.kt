package com.example.jokerfinder.base.di

import com.example.jokerfinder.features.favoritemovies.FavoriteMovieFragment
import com.example.jokerfinder.features.moviedetails.MovieDetailsFragment
import com.example.jokerfinder.features.searchmovie.SearchMovieFragment
import com.example.jokerfinder.repository.DataRepository
import dagger.Component

@Component(modules = [ModuleRepository::class])
interface ProvideRepository {

    fun getRepository() : DataRepository

    fun getSearchMovieFragment(searchMovieFragment: SearchMovieFragment)
    fun getMovieDetailsFragment(movieDetailsFragment: MovieDetailsFragment)
    fun getFavoriteMovieFragment(favoriteMovieFragment: FavoriteMovieFragment)

}