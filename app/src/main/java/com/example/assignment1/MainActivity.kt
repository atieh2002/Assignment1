package com.example.assignment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.BTResult)
        val TotalTV: TextView = findViewById(R.id.Total)
        val subtotalP: TextView = findViewById((R.id.subtotalP))
        val subtotalB: TextView = findViewById((R.id.subtotalB))
        var flagP: String = "0"
        var flagB: String = "0"
        val spinnerP: Spinner = findViewById((R.id.SPpizza))
        val spinnerB: Spinner = findViewById((R.id.SPburger))

        val options = arrayOf("0", "1", "2", "3", "4", "5", "6", "7", "8", "9")


        spinnerP.adapter =
            ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, options)
        spinnerP.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flagP = options.get(p2)
                subtotalP.text = (flagP.toInt() * 5).toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }


        }
spinnerB.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, options)
        spinnerB.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flagB = options.get(p2)
                subtotalB.text = (flagB.toInt() * 4).toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        button.setOnClickListener{ view ->

                TotalTV.text = calculate((subtotalP.text).toString(), (subtotalB.text).toString()).toString()
        }
    }

    public fun calculate(a: String, b: String): Int {

        var pizza: Int = a.toInt();
        var burger: Int = b.toInt();


        return pizza + burger;
    }
}