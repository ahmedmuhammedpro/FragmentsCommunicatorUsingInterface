package com.example.fragmentscommunicatorusinginterface

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_counter_screen.*
import kotlinx.android.synthetic.main.fragment_counter_screen.view.*

class FragmentCounterScreen : Fragment() {

    private var mCounter = 0
    var moveToFragmentCounter: FragmentCounterScreenInterface.MoveToFragmentCounter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_counter_screen, container, false)
        view.moveToFragmentCounter.setOnClickListener {
            moveToFragmentCounter?.moveToFragmentCounter()
        }
        return view
    }

    override fun onStart() {
        super.onStart()

    }

    fun changeCounter(counter: Int) {
        mCounter = counter
        counterTextView.text = "$mCounter"
    }
}

interface FragmentCounterScreenInterface {

    interface MoveToFragmentCounter {
        fun moveToFragmentCounter()
    }

    interface Communicator {
        fun respond(counter: Int)
    }
}