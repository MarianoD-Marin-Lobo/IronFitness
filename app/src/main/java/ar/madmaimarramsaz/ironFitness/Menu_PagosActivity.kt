package ar.madmaimarramsaz.ironFitness

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class Menu_PagosActivity : AppCompatActivity() {
    private lateinit var btnPagoMensualSocio: Button
    private lateinit var btnPagoActividadDiaria: Button
    private lateinit var btnVerHistorialPagos: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu_pagos)


        btnPagoMensualSocio = findViewById(R.id.menu_pagos_pago_cuota_mensual_socio_button)
        btnPagoActividadDiaria = findViewById(R.id.menu_pagos_pago_activ_diaria_button)
        btnVerHistorialPagos = findViewById(R.id.menu_pagos_historial_pagos_button)

        // Boton de pago cuota Mensual
        btnPagoMensualSocio.setOnClickListener {
            // Se abre la ventana a la pagina de pagos
            val intent = Intent(this, Nuevo_Pago_Pag1_Activity::class.java)
            startActivity(intent)
        }

        // Boton de pago Actividad Diaria
        btnPagoActividadDiaria.setOnClickListener {
            // Se abre la ventana a la pagina de pagos
            val intent = Intent(this, Nuevo_Pago_Pag1_Activity::class.java)
            startActivity(intent)
        }

        // Boton Ver Historial de Pagos
        btnVerHistorialPagos.setOnClickListener {
            // Se abre la ventana al Historial de Pagos
            val intent = Intent(this, Historial_Pagos_Activity::class.java)
            startActivity(intent)
        }
    }
}
