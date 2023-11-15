// Mendeklarasikan package yang digunakan dalam proyek
package com.example.api

// Mengimpor kelas-kelas yang dibutuhkan dari Android SDK dan pustaka lainnya
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.api.model.Laptops
import com.squareup.picasso.Picasso

// Mendefinisikan kelas adapter untuk RecyclerView yang akan digunakan untuk menampilkan data laptops
class LaptopAdapter(private val mList: List<Laptops>) : RecyclerView.Adapter<LaptopAdapter.ViewHolder>() {

    // Metode yang dipanggil ketika ViewHolder baru perlu dibuat.
    // Inflate layout item dan membuat ViewHolder berdasarkan layout tersebut.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.laptops, parent, false)
        return ViewHolder(view)
    }

    // Metode yang memberikan jumlah item dalam dataset.
    override fun getItemCount(): Int {
        return mList.size
    }

    // Metode yang mengikat data ke ViewHolder di posisi tertentu dalam dataset.
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Mendapatkan data laptop pada posisi tertentu dalam daftar
        val laptops = mList[position]

        // Mengatur teks judul pada TextView di ViewHolder
        holder.judultxt.text = laptops.title

        // Menggunakan Picasso untuk memuat gambar thumbnail ke dalam ImageView di ViewHolder
        Picasso.get().load(laptops.thumbnail).into(holder.imageView)

        // Mengatur teks harga, rating, brand, stok, dan deskripsi pada TextView di ViewHolder
        holder.harga.text = laptops.price.toString()
        holder.rating.text = laptops.rating.toString()
        holder.brand.text = laptops.brand.toString()
        holder.stok.text = laptops.stock.toString()
        holder.deskripsi.text = laptops.description.toString()
    }

    // Mendefinisikan kelas ViewHolder yang merepresentasikan tampilan item dalam RecyclerView
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Mendeklarasikan dan menginisialisasi elemen-elemen UI dalam item
        val imageView: ImageView = itemView.findViewById(R.id.imageview)
        val judultxt: TextView = itemView.findViewById(R.id.namatext)
        val harga: TextView = itemView.findViewById(R.id.hargatxt)
        val rating: TextView = itemView.findViewById(R.id.ratingtxt)
        val brand: TextView = itemView.findViewById(R.id.brandstxt)
        val stok: TextView = itemView.findViewById(R.id.stoktxt)
        val deskripsi: TextView = itemView.findViewById(R.id.deskripsitext)
    }
}
