package com.jojo.viewmodellivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.jojo.viewmodellivedata.viewModel.TemperatureViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var temperatureViewModel: TemperatureViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // UI components
        val celsiusEditText: EditText = findViewById(R.id.celsiusEditText)
        val updateButton: Button = findViewById(R.id.updateButton)
        val celsiusTextView: TextView = findViewById(R.id.celsiusTextView)
        val fahrenheitTextView: TextView = findViewById(R.id.fahrenheitTextView)

        // Initialize the ViewModel
        temperatureViewModel = ViewModelProvider(this).get(TemperatureViewModel::class.java)

        // Observe the Celsius LiveData
        temperatureViewModel.celsius.observe(this, Observer { temp ->
            celsiusTextView.text = "Celsius: $temp"
        })

        // Observe the derived Fahrenheit LiveData
        temperatureViewModel.fahrenheit.observe(this, Observer { fTemp ->
            fahrenheitTextView.text = "Fahrenheit: $fTemp"
        })

        // Update the temperature when the button is clicked
        updateButton.setOnClickListener {
            val newTemp = celsiusEditText.text.toString().toFloatOrNull() ?: 0f
            temperatureViewModel.updateCelsius(newTemp)
        }
    }
}
