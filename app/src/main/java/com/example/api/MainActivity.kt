package com.example.api // Mendefinisikan nama package

import androidx.appcompat.app.AppCompatActivity // Mengimpor kelas AppCompatActivity dari library androidx
import android.os.Bundle // Mengimpor kelas Bundle dari library android
import android.util.Log // Mengimpor kelas Log dari library android untuk melakukan logging
import androidx.recyclerview.widget.LinearLayoutManager // Mengimpor kelas LinearLayoutManager dari library androidx.recyclerview.widget
import com.example.api.databinding.ActivityMainBinding // Mengimpor kelas ActivityMainBinding yang dihasilkan oleh data binding
import com.example.api.model.Data // Mengimpor kelas Data dari package com.example.api.model
import com.example.api.model.Laptops // Mengimpor kelas Smartphones dari package com.example.api.model
import com.example.api.retrofit.ApiClient // Mengimpor kelas ApiClient dari package com.example.api.retrofit
import com.example.api.retrofit.ApiService // Mengimpor kelas ApiService dari package com.example.api.retrofit
import retrofit2.Call // Mengimpor kelas Call dari library retrofit2

class MainActivity : AppCompatActivity() { // Mendeklarasikan kelas MainActivity yang merupakan turunan dari AppCompatActivity

    private lateinit var binding: ActivityMainBinding // Mendeklarasikan variabel binding dengan tipe data ActivityMainBinding

    var data = ArrayList<Laptops>() // Mendeklarasikan variabel data dengan tipe data ArrayList<Laptops>

    override fun onCreate(savedInstanceState: Bundle?) { // Mendefinisikan fungsi onCreate yang dijalankan saat activity dibuat
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater) // Menginisialisasi variabel binding dengan menggunakan metode inflate dari ActivityMainBinding
        setContentView(binding.root) // Menetapkan tata letak activity dengan menggunakan root dari binding

        binding.recyview.layoutManager = LinearLayoutManager(this) // Mengatur layout manager untuk recycler view menggunakan LinearLayoutManager

        getAllLaptops() // Memanggil fungsi getAllLaptops
    }

    private fun getAllLaptops() { // Mendefinisikan fungsi getAllLaptops untuk mendapatkan data laptops dari API
        val retrofit = ApiClient.buildService(ApiService::class.java) // Membuat instance retrofit dengan menggunakan ApiClient dan ApiService

        retrofit.getAllLaptops().enqueue(object : retrofit2.Callback<Data> { // Mengeksekusi permintaan API menggunakan retrofit
            override fun onResponse(call: Call<Data>, response: retrofit2.Response<Data>) { // Menangani respon dari permintaan API yang berhasil
                try {
                    val responseBody = response.body() // Mendapatkan tubuh respon

                    if (responseBody != null && responseBody.products.isNotEmpty()) { // Memeriksa apakah tubuh respon tidak null dan memiliki produk yang tidak kosong
                        data = responseBody.products // Mengisi variabel data dengan produk dari respon
                        val adapter = LaptopAdapter(data) // Membuat adapter menggunakan data
                        binding.recyview.adapter = adapter // Menetapkan adapter untuk recycler view
                    } else {
                        Log.e("Response Error", "Product not Available") // Mencatat kesalahan jika produk tidak tersedia
                    }
                } catch (ex: Exception) {
                    ex.printStackTrace() // Menangani pengecualian dengan mencetak jejak ke stack trace
                }
            }

            override fun onFailure(call: Call<Data>, t: Throwable) { // Menangani kegagalan permintaan API
                Log.e("Failed", "onFailure: ${t.message}") // Mencatat pesan kegagalan
            }
        })
    }
}
