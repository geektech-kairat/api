package com.example.kotlin.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kotlin.`object`.Constant
import com.example.kotlin.base.BaseViewModel
import com.example.kotlin.builder.RetrofitClient
import com.example.kotlin.data.remote.ApiService
import com.example.kotlin.data.remote.model.PlayList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : BaseViewModel() {

    fun fetchPlayList(): LiveData<PlayList?> {

        return fetchYoutubeApiPlayList()
    }

    private var apiService: ApiService? = null

    private fun fetchYoutubeApiPlayList(): LiveData<PlayList?> {
        apiService = RetrofitClient.create()
        val data = MutableLiveData<PlayList?>()
        apiService?.fetchAllPlayList(Constant.API_KEY, Constant.PART, Constant.CHANNEL_ID)
            ?.enqueue(object : Callback<PlayList>{
                override fun onResponse(call: Call<PlayList>, response: Response<PlayList>) {
                    data.value = response.body()

                }

                override fun onFailure(call: Call<PlayList>, t: Throwable) {
                    data.value = null
                }
            })
        return data
    }
}