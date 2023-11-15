package com.example.api.model // Mendefinisikan nama package

import com.google.gson.annotations.SerializedName // Mengimpor anotasi SerializedName dari library Gson

// Mendeklarasikan kelas Data sebagai data class yang merupakan final
data class Data(
    @SerializedName("products") var products: ArrayList<Laptops> = arrayListOf(), // Menandai nama field "products" pada respon JSON
    @SerializedName("total") var total: Int? = null, // Menandai nama field "total" pada respon JSON
    @SerializedName("skip") var skip: Int? = null, // Menandai nama field "skip" pada respon JSON
    @SerializedName("limit") var limit: Int? = null // Menandai nama field "limit" pada respon JSON
)

// Mendeklarasikan data class Laptop
data class Laptops(
    @SerializedName("id") var id: Int? = null, // Menandai nama field "id" pada respon JSON
    @SerializedName("title") var title: String? = null, // Menandai nama field "title" pada respon JSON
    @SerializedName("description") var description: String? = null, // Menandai nama field "description" pada respon JSON
    @SerializedName("price") var price: Int? = null, // Menandai nama field "price" pada respon JSON
    @SerializedName("discountPercentage") var discountPercentage: Double? = null, // Menandai nama field "discountPercentage" pada respon JSON
    @SerializedName("rating") var rating: Double? = null, // Menandai nama field "rating" pada respon JSON
    @SerializedName("stock") var stock: Int? = null, // Menandai nama field "stock" pada respon JSON
    @SerializedName("brand") var brand: String? = null, // Menandai nama field "brand" pada respon JSON
    @SerializedName("category") var category: String? = null, // Menandai nama field "category" pada respon JSON
    @SerializedName("thumbnail") var thumbnail: String? = null, // Menandai nama field "thumbnail" pada respon JSON
    @SerializedName("images") var images: ArrayList<String> = arrayListOf() // Menandai nama field "images" pada respon JSON
)
