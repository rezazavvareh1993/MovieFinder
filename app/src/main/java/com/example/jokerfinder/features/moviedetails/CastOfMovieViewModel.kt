package com.example.jokerfinder.features.moviedetails

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jokerfinder.pojoes.Credits
import com.example.jokerfinder.repository.DataRepository
import com.example.jokerfinder.repository.di.DaggerProvideRepositoryComponent
import com.example.jokerfinder.utils.MyConstantClass
import io.reactivex.disposables.CompositeDisposable

class CastOfMovieViewModel : ViewModel() {
    private val disposable = CompositeDisposable()
    private val component = DaggerProvideRepositoryComponent.create()
    private val repository = component.provideRepository()
    private var castOfMovieMutableLiveData = MutableLiveData<Credits>()

    fun fetchCastOfMovieData(idMovie : Int, context: Context){
        disposable.add(
            repository.fetchCastsOfMovie(idMovie)
                .subscribe({
                    castOfMovieMutableLiveData.value = it

                },{
                    Log.d("MyTag", it.message)
                    MyConstantClass.showToast(context, it.message)
                    castOfMovieMutableLiveData.value = null
                })
        )
    }

    fun getCastOfMovieData() : LiveData<Credits> = castOfMovieMutableLiveData

    /**
     * Clearing the RX disposable
     */
    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}