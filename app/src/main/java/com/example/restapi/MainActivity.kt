package com.example.restapi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.restapi.model.Carro
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun click(v: View) {
        val call = RetrofitInitializer().carroService().find()
        call.enqueue(object : Callback<List<Carro>?> {
            override fun onFailure(call: Call<List<Carro>?>, t: Throwable) {
                Toast.makeText(this@MainActivity, "erro: ${t.message}", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<Carro>?>, response: Response<List<Carro>?>) {
                response?.body()?.let {
                    val carros = it
                    carros.forEach{
                        Toast.makeText(this@MainActivity, "Carro: ${it.nome}", Toast.LENGTH_SHORT).show()
                    }
                }

            }

        })

    }
}
