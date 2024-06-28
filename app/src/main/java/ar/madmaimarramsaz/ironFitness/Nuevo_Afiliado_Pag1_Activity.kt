package ar.madmaimarramsaz.ironFitness

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class Nuevo_Afiliado_Pag1_Activity : AppCompatActivity() {


    //CRUD
    private lateinit var radioGroupSocio: RadioGroup
    private lateinit var selector_socio_radbtn: RadioButton
    private lateinit var selectornoSocioradbtn: RadioButton
    private lateinit var nuevo_afiliado_pag1_input_aptoMed: EditText
    private lateinit var input_fecha_afiliacion: EditText
    private lateinit var btnSiguiente: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_nuevo_afiliado_pag1)

        radioGroupSocio = findViewById(R.id.radioGroupSocio)
        selector_socio_radbtn = findViewById(R.id.selector_socio_radbtn)
        selectornoSocioradbtn = findViewById(R.id.selectornoSocioradbtn)
        nuevo_afiliado_pag1_input_aptoMed = findViewById(R.id.nuevo_afiliado_pag1_input_aptoMed)
        input_fecha_afiliacion = findViewById(R.id.inputFechaAfiliacion)
        btnSiguiente = findViewById(R.id.container_btn_siguiente)

        btnSiguiente.setOnClickListener {
            val esSocio = when (radioGroupSocio.checkedRadioButtonId) {
                R.id.selector_socio_radbtn -> true
                R.id.selectornoSocioradbtn -> false
                else -> false
            }
            val aptoMed = nuevo_afiliado_pag1_input_aptoMed.text.toString()
            val fechaAfil = input_fecha_afiliacion.text.toString()

            val intent = Intent(this, Nuevo_Afiliado_Pag2_Activity::class.java).apply {
                putExtra("esSocio", esSocio)
                putExtra("aptoMed", aptoMed)
                putExtra("fechaAfil", fechaAfil)
            }
            startActivity(intent)
        }

        // boton volver a la ventana anterior
        val btn_volver: Button = findViewById(R.id.image_back_button)

        btn_volver.setOnClickListener {
            finish()
        }

        // barra de navegacion Boton 1 Pagar

        val btn_pagar: Button = findViewById(R.id.image_low_menu_quad)

        btn_pagar.setOnClickListener {
            irAPagos()
        }

        // barra de navegacion Boton 2 ir a Home

        val btn_home: Button = findViewById(R.id.image_low_menu_quad1)

        btn_home.setOnClickListener {
            irAHome()
        }

        // barra de navegacion Boton 3 ir a Gestión Afiliados
        val btn_gestionAfiliado: Button = findViewById(R.id.image_low_menu_quad2)

        btn_gestionAfiliado.setOnClickListener {
            irAGestionAfiliado()
        }
    }
    // Funciones
    private fun irAPagos(){
        val intent = Intent(this, Menu_PagosActivity::class.java)
        startActivity(intent)
    }

    private fun irAHome(){
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }

    private fun irAGestionAfiliado(){
        val intent = Intent(this, GestionAfiliadoActivity::class.java)
        startActivity(intent)
    }




}