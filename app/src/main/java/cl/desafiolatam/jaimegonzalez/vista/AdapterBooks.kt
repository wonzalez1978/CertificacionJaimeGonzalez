package cl.desafiolatam.jaimegonzalez.vista

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cl.desafiolatam.jaimegonzalez.R
import cl.desafiolatam.jaimegonzalez.modelo.BooksPojo
import kotlinx.android.synthetic.main.itembooks.view.*

class AdapterBooks(private var myDataset: MutableList<BooksPojo>) :
    RecyclerView.Adapter<AdapterBooks.BooksVH>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksVH {
        val booksList =
            LayoutInflater.from(parent.context).inflate(R.layout.itembooks, parent, false)
        return BooksVH(booksList)
    }

    override fun onBindViewHolder(holder: BooksVH, position: Int) {
        holder.titulo.text = myDataset[position].title
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

    }
}