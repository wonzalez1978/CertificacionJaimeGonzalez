package cl.desafiolatam.jaimegonzalez.vista

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import cl.desafiolatam.jaimegonzalez.R
import cl.desafiolatam.jaimegonzalez.modelo.BooksPojo
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.itembooks.view.*

class AdapterBooks(private var myDataset: MutableList<BooksPojo>) :
    RecyclerView.Adapter<AdapterBooks.BooksVH>() {

    val bookSelected = MutableLiveData<BooksPojo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksVH {
        val booksList =
            LayoutInflater.from(parent.context).inflate(R.layout.itembooks, parent, false)
        return BooksVH(booksList)
    }

    override fun onBindViewHolder(holder: BooksVH, position: Int) {
        holder.titulo.text = myDataset[position].title
        Picasso.get().load(myDataset[position].imageLink).into(holder.imagen)
        holder.autor.text = myDataset[position].author
        holder.idioma.text = myDataset[position].language
        holder.itemView.setOnClickListener {
            Log.d("Adapter", "${myDataset[position]}")
            bookSelected.value = myDataset[position]

        }


    }

    override fun getItemCount(): Int {
        return myDataset.size
    }

    fun upDateAdapter(listaResult: List<BooksPojo>) {
        myDataset.clear()
        myDataset.addAll(listaResult)
        notifyDataSetChanged()
    }

    class BooksVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var titulo: TextView = itemView.tv_title
        val imagen: ImageView = itemView.iv_book
        val autor: TextView = itemView.tv_titulo
        var idioma: TextView = itemView.tv_idiona

    }
}