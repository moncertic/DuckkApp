package com.example.tamagotchi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.modelProvider

class CleanFragment : Fragment() {
    private lateinit var model: Duckmodel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.clean_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        model = modelProvider(requireActivity()).get(Duckmodel::class.java)

        model.hygiene.observe(viewLifecycleOwner, Observer { hygiene ->
            // Assuming you have a TextView named hungerPercentage in your feed_fragment.xml
            val textView = view.findViewById<TextView>(R.id.txtHygiene)
            // Format the hunger level as a percentage and update the TextView
            textView.text = "${hygiene}%"
        })

        view.findViewById<Button>(R.id.btnClean).setOnClickListener {
            model.cleanDuck()
        }
    }
}