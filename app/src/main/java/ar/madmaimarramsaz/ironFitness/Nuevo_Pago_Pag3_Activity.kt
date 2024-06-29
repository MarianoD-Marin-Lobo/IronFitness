package ar.madmaimarramsaz.ironFitness

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import ar.madmaimarramsaz.ironFitness.Entidades.Pago
import ar.madmaimarramsaz.ironFitness.repositories.PagoRepository
import android.widget.Toast

class Nuevo_Pago_Pag3_Activity : AppCompatActivity() {
    private lateinit var pagoRepository: PagoRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_nuevo_pago_pag3)


        val nombApell = intent.getStringExtra("nombApell") ?: ""
        val nroIdentif = intent.getStringExtra("nroIdentif") ?: ""
        val tipoIdentif = intent.getStringExtra("tipoIdentif") ?: ""
        val nroAfil = intent.getStringExtra("nroAfil") ?: ""
        val tipoDeCuota = intent.getStringExtra("tipoCuota") ?: ""
        val comentEquip = intent.getStringExtra("comentEquip") ?: ""
        val fechaPago = intent.getStringExtra("fechaPago") ?: ""
        val importeAPag = intent.getStringExtra("importeAPag") ?: ""

        val txtShowPrice = findViewById<TextView>(R.id.txt_showPrice)
        txtShowPrice.text = importeAPag

        var spinnerModalPago: Spinner = findViewById(R.id.np_pag3_spinnerModPago)
        val items = arrayOf("Seleccione modalidad de Pago", "EFECTIVO", "Tarjeta DÉBITO", "Tarjeta CRÉDITO")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerModalPago.adapter = adapter
        spinnerModalPago.prompt = "Seleccione modalidad de Pago"

        val txtWarningMsg = findViewById<TextView>(R.id.txt_warningMsg)

        spinnerModalPago.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long): Unit {
                when (position) {
                    0 -> txtWarningMsg.text = ""
                    1 -> txtWarningMsg.text = ""
                    2 -> txtWarningMsg.text = "Verifique el éxito del cobro en su terminal de tarjetas antes de confirmar el registro del pago"
                    3 -> txtWarningMsg.text = "Verifique el éxito del cobro en su terminal de tarjetas antes de confirmar el registro del pago"
                    else -> txtWarningMsg.text = "Error: Modalidad de pago no válida"
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        pagoRepository = PagoRepository(BaseDatos(this))

        // boton Confirmar
        val btn_confirmar: Button = findViewById(R.id.container_btn_confirmar)
        btn_confirmar.setOnClickListener {
            val modPago = spinnerModalPago.selectedItem.toString()
            if (modPago == "Seleccione modalidad de Pago") {
                Toast.makeText(this, "Por favor complete la modalidad de pago.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }


            val pago = Pago (
                nombresApellidos = nombApell,
                nroIdentificacion = nroIdentif,
                tipoIdentificacion = tipoIdentif,
                nroAfiliado = nroAfil,
                tipoCuota = tipoDeCuota,
                comentarioEquipamiento = comentEquip,
                fechaPago = fechaPago,
                importeAPagar = importeAPag,
                modalidadDePago = modPago
            )

            val pagoId = pagoRepository.createPago(pago)
            Log.d("NuevoPago", "Pago registrado con ID: $pagoId")

            if (pagoId > 0) {
                Log.d("PagoRepository", "Pago registrado con ID: $pagoId")
                Toast.makeText(this, "Pago registrado correctamente.", Toast.LENGTH_SHORT).show()
                intent.putExtra("pagoId", pagoId)
                val intent = Intent(this, Nuevo_Pago_Pag4_Activity::class.java)
                startActivity(intent)
            } else {
                Log.e("PagoRepository", "Error al insertar el pago")
                Toast.makeText(this, "Error al registrar el pago. Inténtelo nuevamente.", Toast.LENGTH_SHORT).show()
            }

        }


        // boton volver a la ventana anterior
        val btn_volver: Button = findViewById(R.id.image_back_button)
        btn_volver.setOnClickListener {
            finish()
        }

        // boton cancelar
        val btn_cancelar: Button = findViewById(R.id.container_btn_cancelar)
        btn_cancelar.setOnClickListener {
            irAPagos()
        }

        // boton anterior
        val btn_anterior: Button = findViewById(R.id.container_btn_anterior)
        btn_anterior.setOnClickListener {
            irAPag2Cuota()
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

    private fun irAPag2Cuota(){
        val intent = Intent(this, Nuevo_Pago_Pag2_Activity::class.java)
        startActivity(intent)
    }



}