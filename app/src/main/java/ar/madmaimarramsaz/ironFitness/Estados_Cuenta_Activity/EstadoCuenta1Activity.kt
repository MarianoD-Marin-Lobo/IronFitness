package ar.madmaimarramsaz.ironFitness.Estados_Cuenta_Activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ar.madmaimarramsaz.ironFitness.R
import android.content.Intent

import android.view.View
import android.widget.Button

class EstadoCuenta1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_estado_cuenta1)
        // Aquí puedes encontrar los botones y configurar los listeners
        val button1 = findViewById<Button>(R.id.button)
        val button2 = findViewById<Button>(R.id.button2)

        // Configurar onClickListener para button1
        button1.setOnClickListener {
            irAEstadoCuenta2()
        }

        // Configurar onClickListener para button2
        button2.setOnClickListener {
            irAEstadoCuenta3()
        }
    }

    private fun irAEstadoCuenta2() {
        val intent = Intent(this, EstadoCuenta2Activity::class.java)
        startActivity(intent)
    }

    private fun irAEstadoCuenta3() {
        val intent = Intent(this, EstadoCuenta3Activity::class.java)
        startActivity(intent)
    }
}