package cl.desafiolatam.jaimegonzalez.vista

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import cl.desafiolatam.jaimegonzalez.R
import cl.desafiolatam.jaimegonzalez.viewmodels.MyViewModel
import kotlinx.android.synthetic.main.fragment_book.*


class BookFragment : Fragment() {

    private lateinit var adapterBooks: AdapterBooks

    private val myViewModel: MyViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_book, container, false)

        adapterBooks = AdapterBooks(mutableListOf())

        myViewModel.obtenerValor()
        myViewModel.getAllBooks.observe(viewLifecycleOwner, Observer{
            adapterBooks.upDateAdapter(it)
        })



        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = recyclerbooks
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        recyclerView.adapter = adapterBooks
    }
}