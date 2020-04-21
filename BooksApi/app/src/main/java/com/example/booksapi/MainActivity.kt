package com.example.booksapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    val link = "https://www.googleapis.com/books/v1/volumes?q=java"
    lateinit var list: MutableList<MyData>
    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recycler)
        list = mutableListOf()
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            fetchData()
        }

    }


    suspend fun fetchData(){
        val url = URL(link)
        val connection: HttpsURLConnection = url.openConnection()
                as HttpsURLConnection
        val ins: InputStream = connection.inputStream
       val reader: BufferedReader = BufferedReader(InputStreamReader(ins))
        val text = ins.bufferedReader().use(BufferedReader::readText)
        withContext(Dispatchers.Main){
            setValueOnResult(text)
        }

    }

    private fun setValueOnResult(text: String){
       /*val t:Toast = Toast.makeText(this,text,Toast.LENGTH_LONG)
        t.show()*/
        val rootObject = JSONObject(text)
        val itemsarray = rootObject.getJSONArray("items")
        for (i in 0..itemsarray.length()-1){
           Log.d("Index",""+i)
            val indexObj = itemsarray.getJSONObject(i)
            val volumeInfo = indexObj.getJSONObject("volumeInfo")
            val title = volumeInfo.getString("title")
            val author = volumeInfo.getString("authors")
            val imgObj = volumeInfo.getJSONObject("imageLinks")
            val imgurl = imgObj.getString("thumbnail")
            list.add(MyData(title,imgurl))
        }
        Log.d("SIZE",""+list.size)
        mainViewModel.list.observe(this, Observer {
            li -> val adapter = MyAdapter(this,li)
            recyclerView.adapter = adapter
        })
        recyclerView.layoutManager = LinearLayoutManager(this)
        //recyclerView.adapter = MyAdapter(this,list)


    }
}
