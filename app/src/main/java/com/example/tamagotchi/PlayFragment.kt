package com.example.tamagotchi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.modelProvider

class PlayFragment : Fragment() {
    private lateinit var model: Duckmodel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.play_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        model = modelProvider(requireActivity()).get(Duckmodel::class.java)

        model.happiness.observe(viewLifecycleOwner, Observer { happiness ->
            // Assuming you have a TextView named hungerPercentage in your feed_fragment.xml
            val textView = view.findViewById<TextView>(R.id.txtHappiness)
            // Format the hunger level as a percentage and update the TextView
            textView.text = "${happiness}%"
        })

        view.findViewById<Button>(R.id.btnPlay).setOnClickListener {
            model.playWithDuck()
        }

        val imageResource = arguments?.getInt("imageResource")?: R.drawable.duck_playing // Use a default image if no resource was passed
        val imageView = view.findViewById<ImageView>(R.id.imgPlay)
        imageView.setImageResource(imageResource)
    }
}
