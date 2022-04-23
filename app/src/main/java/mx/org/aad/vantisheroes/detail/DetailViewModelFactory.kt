package mx.org.aad.vantisheroes.detail

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import mx.org.aad.vantisheroes.network.RickProperty

class DetailViewModelFactory(
    private val rickProperty: RickProperty,
    private val application: Application) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(rickProperty, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
