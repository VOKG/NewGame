package com.example.sudokusolver.com.newgame

import CheckOutcome
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.burPuzzel).setOnClickListener {
            val result =  validatePuzzel(this.resources)
            val resultString = when( result){
                CheckOutcome.Ok -> "Puzzel is correct"
                CheckOutcome.Incomplete -> "Puzzel is incomplete"
                CheckOutcome.Failed -> "Puzzel is wrong"


            }
            findViewById<TextView>(R.id.textView_result).text = resultString
        }
    }
}