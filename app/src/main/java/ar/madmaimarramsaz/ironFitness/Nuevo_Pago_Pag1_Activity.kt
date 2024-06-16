package ar.madmaimarramsaz.ironFitness

import android.os.Bundle
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Spinner
import android.widget.ArrayAdapter
import android.text.Html

class Nuevo_Pago_Pag1_Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_nuevo_pago_pag1)

        val spinner: Spinner = findViewById(R.id.nuevo_pago_pag1_spinner)
// Define the items to be displayed in the spinner, including a hint item
        val items = arrayOf("TIPO Id.", "DNI", "Nº Afiliado")

// Create an ArrayAdapter using the modified string array and a default spinner layout
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, items)

// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

// Apply the adapter to the spinner
        spinner.adapter = adapter

// Set the spinner's prompt to be the hint item
        spinner.prompt = "TIPO Id."
        }
    }
