package com.example.api.retrofit // Mendefinisikan nama package

import com.example.api.model.Data // Mengimpor kelas Data dari package com.example.api.model
import retrofit2.Call // Mengimpor kelas Call dari library retrofit2
import retrofit2.http.GET // Mengimpor anotasi GET dari library retrofit2.http
import retrofit2.http.Headers // Mengimpor anotasi Headers dari library retrofit2.http

interface ApiService { // Mendefinisikan antarmuka ApiService

    @Headers("Content-Type:application/json") // Menetapkan header "Content-Type" pada permintaan HTTP
    @GET("/products/category/laptops") // Menetapkan metode HTTP GET dengan path "/products/category/laptops"
    fun getAllLaptops(): Call<Data> // Mendeklarasikan fungsi getAllSmartphones yang mengembalikan objek Call<Data>
}
