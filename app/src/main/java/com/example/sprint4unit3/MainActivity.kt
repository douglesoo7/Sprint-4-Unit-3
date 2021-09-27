package com.example.sprint4unit3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private var resultsDTOList: List<ResultsDTO> = listOf<ResultsDTO>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSearch.setOnClickListener(View.OnClickListener {
            callAPI()
        })


    }

    private fun callAPI() {
        val apiClient = Network.getRetrofit().create(ApiClient::class.java)

        apiClient.getSongs(searchKeywords.text.toString())
            .enqueue(object : Callback<ResponseDTO>{
                override fun onResponse(call: Call<ResponseDTO>, response: Response<ResponseDTO>) {
                    resultsDTOList=response.body()?.results as List<ResultsDTO>
                    setRecyclerView()
                }

                override fun onFailure(call: Call<ResponseDTO>, t: Throwable) {
                   t.printStackTrace()
                }


            })
    }

    private fun setRecyclerView() {
        val songsAdapter=SongsAdapter(resultsDTOList)
        val linearLayoutManager=LinearLayoutManager(this)
        recyclerView.adapter=songsAdapter
        recyclerView.layoutManager=linearLayoutManager
    }
}