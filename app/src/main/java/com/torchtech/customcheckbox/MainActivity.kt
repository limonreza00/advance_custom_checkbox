package com.torchtech.customcheckbox

import android.os.Bundle
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val processor = findViewById<CheckBox>(R.id.processor)
        val mainBoard = findViewById<CheckBox>(R.id.mainBoard)
        val ram = findViewById<CheckBox>(R.id.ram)
        val monitor = findViewById<CheckBox>(R.id.monitor)
        val keyboard = findViewById<CheckBox>(R.id.keyboard)
        val display = findViewById<TextView>(R.id.display)

        val checkboxChangeListener = CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            when (buttonView.id){

                R.id.processor -> display.append("Processor\n")
                R.id.ram -> display.append("Ram\n")
                R.id.mainBoard -> display.append("Main-board\n")
                R.id.monitor -> display.append("Monitor\n")
                R.id.keyboard -> display.append("Keyboard\n")

            }
        }

        processor.setOnCheckedChangeListener(checkboxChangeListener)
        ram.setOnCheckedChangeListener(checkboxChangeListener)
        mainBoard.setOnCheckedChangeListener(checkboxChangeListener)
        monitor.setOnCheckedChangeListener(checkboxChangeListener)
        keyboard.setOnCheckedChangeListener(checkboxChangeListener)

    }
}