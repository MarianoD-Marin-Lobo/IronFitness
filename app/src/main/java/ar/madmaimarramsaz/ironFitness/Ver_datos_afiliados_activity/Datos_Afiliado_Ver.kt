package ar.madmaimarramsaz.ironFitness.Ver_datos_afiliados_activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ar.madmaimarramsaz.ironFitness.BaseDatos
import ar.madmaimarramsaz.ironFitness.Entidades.Afiliado
import ar.madmaimarramsaz.ironFitness.GestionAfiliadoActivity
import ar.madmaimarramsaz.ironFitness.HomeActivity
import ar.madmaimarramsaz.ironFitness.Menu_PagosActivity
import ar.madmaimarramsaz.ironFitness.R
import ar.madmaimarramsaz.ironFitness.repositories.AfiliadoRepository
import androidx.appcompat.app.AlertDialog

class Datos_Afiliado_Ver : AppCompatActivity() {
    private lateinit var afiliadoRepository: AfiliadoRepository
    private var afiliadoId: Long = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datos_afiliado_ver)

        // Inicializar el repositorio
        val database = BaseDatos(this)
        afiliadoRepository = AfiliadoRepository(database)

        // Habilitar modo de pantalla completa (edge-to-edge)
        enableEdgeToEdge()

        // Obtener el ID del Afiliado desde el Intent
        afiliadoId = intent.getLongExtra("idAfiliado", -1)
        Log.d("Datos_Afiliado_Ver", "ID del Afiliado recibido: $afiliadoId")

        if (afiliadoId == -1L) {
            Toast.makeText(this, "ID de afiliado no válido", Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        // Obtener el Afiliado por su ID usando el repositorio
        val afiliado: Afiliado? = afiliadoRepository.getAfiliadoById(afiliadoId)
        Log.d("Datos_Afiliado_Ver", "Afiliado obtenido: $afiliado")

        // Vincular vistas
        val labelRol: TextView = findViewById(R.id.labelRol)
        val checkSocio: CheckBox = findViewById(R.id.checkSocio)
        val checkNoSocio: CheckBox = findViewById(R.id.checkNoSocio)
        val input3: EditText = findViewById(R.id.input3)
        val input4: EditText = findViewById(R.id.input4)
        val input2: EditText = findViewById(R.id.input2)

        // Hacer que los EditText sean de solo lectura
        input3.isEnabled = false
        input4.isEnabled = false
        input2.isEnabled = false
        checkSocio.isEnabled = false
        checkNoSocio.isEnabled = false

        // Asignar datos del afiliado a las vistas
        afiliado?.let {
            labelRol.text = "Rol:"
            checkSocio.isChecked = it.esSocio
            checkNoSocio.isChecked = !it.esSocio
            input3.setText(it.aptoMedico)
            input4.setText(it.fechaAfiliacion)
            input2.setText("${it.persona.nombre} ${it.persona.apellido}")
        }

        // Configurar botones de navegación
        val btnVolver: Button = findViewById(R.id.button1)
        val btnBorrar: Button = findViewById(R.id.button2)
        val btnEditar: Button = findViewById(R.id.button3)
        val btnPagar: Button = findViewById(R.id.image_low_menu_quad)
        val btnHome: Button = findViewById(R.id.image_low_menu_quad1)
        val btnGestionAfiliado: Button = findViewById(R.id.image_low_menu_quad2)

        btnVolver.setOnClickListener { irAGestionAfiliado() }
        btnPagar.setOnClickListener { irAPagos() }
        btnHome.setOnClickListener { irAHome() }
        btnBorrar.setOnClickListener { borrarAfiliadoYPersona() }
        btnEditar.setOnClickListener { irAGestionAfiliado() }
        btnGestionAfiliado.setOnClickListener { irAGestionAfiliado() }
    }

    private fun borrarAfiliadoYPersona() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Confirmación")
        builder.setMessage("¿Estás seguro de que deseas borrar este afiliado y su persona asociada? Esta acción no se puede deshacer.")

        builder.setPositiveButton("Sí") { dialog, which ->
            // Llamar al método de borrado en el repositorio
            afiliadoRepository.borrarAfiliadoYPersona(afiliadoId)
            Toast.makeText(this, "Afiliado y persona asociada borrados correctamente", Toast.LENGTH_SHORT).show()

            // Emitir evento de borrado
            val intent = Intent("afiliado_borrado")
            sendBroadcast(intent)

            // Finalizar la actividad
            finish()
        }

        builder.setNegativeButton("No") { dialog, which ->
            dialog.dismiss() // Cancelar el diálogo y no hacer nada
        }

        val dialog = builder.create()
        dialog.show()
    }


    private fun irAPagos() {
        val intent = Intent(this, Menu_PagosActivity::class.java)
        startActivity(intent)
    }

    private fun irAHome() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }

    private fun irAGestionAfiliado() {
        val intent = Intent(this, GestionAfiliadoActivity::class.java)
        startActivity(intent)
    }
}