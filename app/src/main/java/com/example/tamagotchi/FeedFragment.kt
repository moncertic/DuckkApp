package com.example.tamagotchi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.modelProvider
import androidx.lifecycle.Observer
import androidx.annotation.Nullable

class FeedFragment : Fragment() {
    private lateinit var model: Duckmodel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.feed_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        model = modelProvider(requireActivity()).get(Duckmodel::class.java)

        model.hunger.observe(viewLifecycleOwner, Observer { hunger ->
            // Assuming you have a TextView named hungerPercentage in your feed_fragment.xml
            val textView = view.findViewById<TextView>(R.id.txtHunger)
            // Format the hunger level as a percentage and update the TextView
            textView.text = "${hunger}%"
        })

        view.findViewById<Button>(R.id.btnFeed).setOnClickListener {
            model.feedDuck()
        }
    }
}
