package com.example.api.retrofit // Mendefinisikan nama package

import okhttp3.OkHttpClient // Mengimpor kelas OkHttpClient dari library okhttp3
import retrofit2.Retrofit // Mengimpor kelas Retrofit dari library retrofit2
import retrofit2.converter.gson.GsonConverterFactory // Mengimpor kelas GsonConverterFactory dari library retrofit2.converter.gson

object ApiClient { // Mendefinisikan objek ApiClient

    private val client = OkHttpClient.Builder().build() // Membuat instance OkHttpClient

    // Retrofit untuk mengonversi API interface menjadi implementasi yang dapat digunakan
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://dummyjson.com/") // Menetapkan base URL API
        .addConverterFactory(GsonConverterFactory.create()) // Menambahkan konverter JSON menggunakan Gson
        .client(client) // Menggunakan OkHttpClient yang telah dikonfigurasi
        .build()

    /**
     * Fungsi generik [buildService] bertanggung jawab untuk membuat layanan Retrofit dari suatu interface tertentu.
     */
    fun <T> buildService(service: Class<T>): T {
        // Memanggil metode create() pada objek retrofit dengan parameter interface service
        return retrofit.create(service)
    }
}
