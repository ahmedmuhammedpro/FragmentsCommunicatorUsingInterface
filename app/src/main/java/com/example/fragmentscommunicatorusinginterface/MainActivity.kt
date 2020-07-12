package com.example.fragmentscommunicatorusinginterface

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), FragmentCounterScreenInterface.Communicator,
                                          FragmentCounterScreenInterface.MoveToFragmentCounter {

    private lateinit var fragmentCounter: FragmentCounter
    private lateinit var fragmentCounterScreen: FragmentCounterScreen
    private val fragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        savedInstanceState.let {
            fragmentCounter = FragmentCounter()
            fragmentCounterScreen = FragmentCounterScreen()
            fragmentCounterScreen.moveToFragmentCounter = this

            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.add(R.id.fragmentContainer, fragmentCounterScreen, "fragmentCounterScreen")
            fragmentTransaction.commit()
        }
    }

    override fun moveToFragmentCounter() {
        val fragments = fragmentManager.fragments
        if (fragments.size == 1) {
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.add(R.id.fragmentContainer, fragmentCounter, "fragmentCounter")
            fragmentTransaction.commit()
        }
    }

    override fun onBackPressed() {
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.remove(fragmentCounter)
        fragmentTransaction.commit()
    }

    override fun respond(counter: Int) {
        fragmentCounterScreen.changeCounter(counter)
    }
}