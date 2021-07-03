package com.example.exam9.ui.Course

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.exam9.model.Education
import com.example.exam9.network.RetrofitService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CourcesViewModel : ViewModel() {

    private val _liveData = MutableLiveData<Education>()
    val liveData:LiveData<Education> = _liveData

    fun getEducation(){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                _liveData.postValue(RetrofitService.retrofitService.getEducation().body())
            }
        }
    }
}