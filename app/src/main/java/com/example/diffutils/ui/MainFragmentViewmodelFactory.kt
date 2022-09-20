package com.example.diffutils.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.diffutils.repository.MainRepository

class MainFragmentViewmodelFactory constructor(private val repository: MainRepository):
                    ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewmodel::class.java)) {
            MainViewmodel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}