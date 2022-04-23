package mx.org.aad.vantisheroes.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import mx.org.aad.vantisheroes.network.RickApi
import mx.org.aad.vantisheroes.network.RickProperty

class OverviewViewModel : ViewModel() {

    private val _response = MutableLiveData<String>()

    private val _properties = MutableLiveData<List<RickProperty>>()

    private val _navigateToSelectedProperty = MutableLiveData<RickProperty>()

    val response: LiveData<String>
        get() = _response

    val properties: LiveData<List<RickProperty>>
        get() = _properties

    val navigateToSelectedProperty: LiveData<RickProperty>
        get() = _navigateToSelectedProperty

    init {
        getRickProperties()
    }

    private fun getRickProperties() {
        viewModelScope.launch {
            try {
                _properties.value = RickApi.retrofitService.getProperties()
                _response.value = "Success: Rick properties retrieved"

            } catch (e: Exception) {
                _response.value = "Failure: ${e.message}"
            }
        }
    }

    fun displayPropertyDetails(rickProperty: RickProperty) {
        _navigateToSelectedProperty.value = rickProperty
    }

    fun displayPropertyDetailsComplete() {
        _navigateToSelectedProperty.value = null
    }
}
