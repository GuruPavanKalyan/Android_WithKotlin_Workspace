package com.example.catfacts

import android.content.Context
import android.net.Uri
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.URI
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class MainActivity : AppCompatActivity() {

    lateinit var result:TextView
    lateinit var pb:ProgressBar
   val link:String = "https://cat-fact.herokuapp.com/facts"

    lateinit var result2:TextView
    lateinit var pb2:ProgressBar
    val link2:String = "https://cat-fact.herokuapp.com/facts"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        result = findViewById(R.id.textview)
        pb = findViewById(R.id.pb)
        pb.visibility = View.GONE
        val btn:Button = findViewById(R.id.btn)
        btn.setOnClickListener {
            // FetchCatFacts(this,result).execute(link)
            pb2.visibility = View.VISIBLE
            CoroutineScope(Dispatchers.IO).launch {
                fetchCatFacts()
            }
        }

        result2 = findViewById(R.id.textview2)
        pb2 = findViewById(R.id.pb2)
        pb2.visibility = View.GONE
        val btn2:Button = findViewById(R.id.btn2)
        btn2.setOnClickListener {
           // FetchCatFacts(this,result).execute(link)
            pb2.visibility = View.VISIBLE
            CoroutineScope(Dispatchers.IO).launch {
                fetchJson()
            }
        }

    }

    suspend fun fetchCatFacts(){
        val url = URL(link)
        val connection:HttpsURLConnection = url.openConnection()
                as HttpsURLConnection
        val ins:InputStream = connection.inputStream
        val reader:BufferedReader = BufferedReader(InputStreamReader(ins))
        val text = ins.bufferedReader().use(BufferedReader::readText)
        withContext(Dispatchers.Main){
            setValueOnResult(text)
        }

    }

    private fun setValueOnResult(text: String) {
        result.text = text
        pb.visibility=View.GONE
    }



    suspend fun fetchJson(){
        val url = URL(link2)
        val connection:HttpsURLConnection = url.openConnection()
                as HttpsURLConnection
        val ins:InputStream = connection.inputStream
        val reader:BufferedReader = BufferedReader(InputStreamReader(ins))
        val text = ins.bufferedReader().use(BufferedReader::readText)
        withContext(Dispatchers.Main){
            setValueOnResult2(text)
        }

    }

    private fun setValueOnResult2(text: String) {
        result2.text = text
        pb2.visibility=View.GONE
    }
    /* class FetchCatFacts(val context:Context,val textView: TextView) :AsyncTask<String,Void,String>(){
         override fun doInBackground(vararg params: String?): String {
             val myLink = params[0]
             //val uri = Uri.parse(myLink)
             val url = URL(myLink)
             val connection:HttpsURLConnection = url.openConnection()
                     as HttpsURLConnection
             val ins:InputStream = connection.inputStream
             val reader:BufferedReader = BufferedReader(InputStreamReader(ins))
             val text = ins.bufferedReader().use(BufferedReader::readText)
             return text
         }

         override fun onPostExecute(result: String?) {
             super.onPostExecute(result)
             textView.text = result
         }


     }*/
}
