package com.minshoe.twintower.basic.dBinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.minshoe.twintower.R
import com.minshoe.twintower.databinding.ActivityBasicDbindingBinding

/**
 * 1. DataBinding{1}:
 *
 * 2. ViewBinding{2}: light weight, binds views to the code
 *
 *
 */


class BasicDBindingActivity : AppCompatActivity() {


    private lateinit var binding: ActivityBasicDbindingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_dbinding)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_basic_dbinding);
        val button: Button = findViewById<Button>(R.id.bindingButton);
        ///binding.submitButton
        button.setOnClickListener {
            displayGreeting()
        }

    }


    /**
     * # A. Problem: how findViewID Works?
     *
     *  FindViewById function, need to obtain references, to views
     *  everytime we use the method, to get reference to view
     *  Android Studio have to go through view hierarchy and find it at RUN-TIME
     *  large app have 100s of view and 100s of layout
     *  conclusion: Reducing performance of large androdi application
     */

    /**
     * ## B. How Databind works?
     *
     * Create binding object that contains the reference to each view, of a layout
     * once binding object is created. All the component of app. access the views and other data through binding object
     * Android system do not go to view hierarchy.
     * Improves the performance of the app a lot
     * + Read + Maintain, Concise.
     * + Compile Time Checking
     *
     * + Eliminate findViewById
     * + no view related erros
     */

    /**
     * ### C. Process of 1. Data Binding
     *
     * Enable Data Binding
     * dataBinding{enabled = true}
     * Wrap XML with layout tags
     * Wrap layout with <layout>
     * Construct a data binding object
     * DataBinding library will create ActivityMainBinding class for reference for activity_main layout
     *
     * Apply Kotlin apply scoping function
     *
     *
     * DataBinding: Drawbacks
     * https://medium.com/androiddevelopers/data-binding-lessons-learnt-4fd16576b719
     * Maintaining issue
     * increase in Coupling and reduces cohesion
     * Instrumentation for test
     *
     *
     */
    private fun displayGreeting() {

        ///Apply Scoping Function
        binding.apply {
            ///Use of apply to set lot of view
            greetingTextView.text = "Hello " + "Sir"
        }

        val messageView: TextView = findViewById(R.id.greetingTextView)
        val nameText: EditText = findViewById(R.id.nameEditText)


        messageView.text = "Hello " + nameText.text

    }

}


/**
 * Misc:
 * Kotlin Synthetic(extension): shorthand, directly call views using their ids///2021depricated
 * this use to cause unexpected error
 *
 *
 */

/**
 * Jetpack compose:
 * high level: Kotlin multiplatform
 * + xml is much quicker to use
 * compose: high on performance, (KMM)
 * compose: are tricky to maintain for new developer
 *
 *
 */