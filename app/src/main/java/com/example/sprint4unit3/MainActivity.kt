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
            .enqueue(object : Callback<List<ResultsDTO>>{
                override fun onResponse(
                    call: Call<List<ResultsDTO>>,
                    response: Response<List<ResultsDTO>>
                ) {
                    resultsDTOList=response.body()!!
                    setRecyclerView()
                }

                override fun onFailure(call: Call<List<ResultsDTO>>, t: Throwable) {
                    TODO("Not yet implemented")
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