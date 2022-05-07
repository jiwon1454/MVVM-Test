package kc.ac.finaltest

import androidx.lifecycle.*
import kc.ac.finaltest.remote.Safe
import kc.ac.finaltest.repository.SafeRepository
import kotlinx.coroutines.launch
import retrofit2.Response
import java.nio.channels.spi.AbstractSelectionKey

class MainViewModel (
    private val safeRepository: SafeRepository
        ): ViewModel(){

    private val _safe : MutableLiveData<Response<Safe>> = MutableLiveData() // 변경 가능한 데이터
    val safe : LiveData<Response<Safe>> = _safe

    fun getList(apiKey: String){
        viewModelScope.launch {
            val response = safeRepository.getSafeList(apiKey)
            _safe.postValue(response)
        }
    }

    class MainViewModelFactory : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return MainViewModel(SafeRepository()) as T
        }
    }

}