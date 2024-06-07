package ar.madmaimarramsaz.ironFitness

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Menu_PagosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu_pagos)

        btnPagoMensualSocio = findViewById(R.id.menu_pagos_pago_cuota_mensual_socio_button)

        // Boton de pago cuota Mensual
        btnPagoMensualSocio.setOnClickListener {

        // Se abre la ventana al home
        val intent = Intent(this, Menu_PagosActivity::class.java)
        startActivity(intent)
        }
    }
}
