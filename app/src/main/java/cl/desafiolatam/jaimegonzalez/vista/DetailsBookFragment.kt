package cl.desafiolatam.jaimegonzalez.vista

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import cl.desafiolatam.jaimegonzalez.R
import cl.desafiolatam.jaimegonzalez.viewmodels.MyViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_details_book.*


class DetailsBookFragment : Fragment() {


    val myViewModel: MyViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_details_book, container, false)
        return view
    }

    companion object {

        @JvmStatic
        fun newInstance() = DetailsBookFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        myViewModel.getBookInformation().observe(viewLifecycleOwner, {

            if (it != null) {
                Log.d("DetailsFragment", it.toString())
                tv_titulo.text = it.title
                Picasso.get().load(it.image).into(iv_imagen)
                tv_lenguaje.text = it.language
                tv_autor.text = it.author
                tv_paginas.text = it.pages.toString()
                tv_año.text = it.year.toString()
                tv_precio.text = it.price.toString()

            } else {
                Log.d("Details", "null")
            }
        })
    }
}