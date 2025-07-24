package com.example.humotransfers

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var sendButton: Button
    private lateinit var instructionLl: LinearLayout
    private lateinit var instructionLoadingLl: LinearLayout
    private lateinit var instructionErrorLl: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sendButton = findViewById(R.id.send_button)
        instructionLl = findViewById(R.id.instruction_ll)
        instructionLoadingLl = findViewById(R.id.instruction_loading_ll)
        instructionErrorLl = findViewById(R.id.instruction_error_ll)

        test()
    }

    private fun test() {
        var currentState = 0 // 0 - loading, 1 - instruction, 2 - error

        sendButton.setOnClickListener {
            currentState = (currentState + 1) % 3

            // Сброс всех состояний в GONE
            instructionLl.visibility = View.GONE
            instructionLoadingLl.visibility = View.GONE
            instructionErrorLl.visibility = View.GONE

            // Обновляем UI и состояние
            when (currentState) {
                0 -> instructionLoadingLl.visibility = View.VISIBLE
                1 -> instructionLl.visibility = View.VISIBLE
                2 -> instructionErrorLl.visibility = View.VISIBLE
            }
        }
    }
}