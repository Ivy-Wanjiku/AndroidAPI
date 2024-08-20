package com.wanjiku.myapplication

import ApiClient
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.wanjiku.myapplication.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvPosts.layoutManager=LinearLayoutManager(this)
        fetchPosts()

    }
    fun fetchPosts(){
        val  apiInterface=ApiClient.buildApiInerface(PostApiInterface::class.java)
        val request=apiInterface.getPosts()
        request.enqueue(object : Callback<List<Post>> {
            override fun onResponse(p0: Call<List<Post>>, p1: Response<List<Post>>) {
if (p1.isSuccessful){
    val  posts=p1.body()
    Toast.makeText(baseContext,"Fetched ${posts!!.size} posts",Toast.LENGTH_LONG).show()
    binding.rvPosts.adapter=PostAdapter(posts)
}
            }

            override fun onFailure(p0: Call<List<Post>>, p1: Throwable) {
Toast.makeText(baseContext,p1.message.toString(),Toast.LENGTH_LONG).show()
            }

        })
    }
}



