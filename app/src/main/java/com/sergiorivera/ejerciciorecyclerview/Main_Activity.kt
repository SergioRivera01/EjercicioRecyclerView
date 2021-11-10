package com.sergiorivera.ejerciciorecyclerview


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson


class Main_Activity : AppCompatActivity() {
    private lateinit var adapter: RepositoryAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvRepositories : RecyclerView = findViewById(R.id.rv_repositories)

        val app = application as App
        var repositories = app.repositories

        val gson: Gson = Gson()
        val results = gson.fromJson(RecyclerFakeData.repositoriesJson, Array<ResultResponse>::class.java)

        repositories.addAll(results.repositories.toRespository())
        results.repositories.forEach { userResponse ->
            repositories.add(userResponse.toRespository())
        }

        adapter = RepositoryAdapter(repositories) { repository ->
            val intent = Intent(this, Detail_Activity::class.java)
            intent.putExtra("repositoryId", repository.id)
            startActivity(intent)
        }
        rvRepositories.adapter = adapter
        val layoutManager = LinearLayoutManager(this)
        rvRepositories.layoutManager = layoutManager
    }
    override fun onResume() {
        super.onResume()
        adapter.notifyDataSetChanged()
    }
}

