package com.example.fragmentscommunicatorusinginterface

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_counter.view.*

class FragmentCounter : Fragment() {

    private lateinit var communicator: FragmentCounterScreenInterface.Communicator
    private var counter = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        communicator = activity as FragmentCounterScreenInterface.Communicator
        val view = inflater.inflate(R.layout.fragment_counter, container, false)
        view.counterButton.setOnClickListener {
            counter++
            communicator.respond(counter)
        }
        return view
    }

}