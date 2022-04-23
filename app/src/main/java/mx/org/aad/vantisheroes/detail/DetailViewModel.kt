package mx.org.aad.vantisheroes.detail

import android.app.Application
import androidx.lifecycle.*
import mx.org.aad.vantisheroes.network.RickProperty

class DetailViewModel(rickProperty: RickProperty,
                      app: Application) : AndroidViewModel(app) {
    private val _selectedProperty = MutableLiveData<RickProperty>()
    val selectedProperty: LiveData<RickProperty>
        get() = _selectedProperty
    init {
        _selectedProperty.value = rickProperty
    }
}

