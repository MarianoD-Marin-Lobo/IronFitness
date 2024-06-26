package ar.madmaimarramsaz.ironFitness

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import ar.madmaimarramsaz.ironFitness.Entidades.Afiliado
import ar.madmaimarramsaz.ironFitness.Entidades.Persona
import ar.madmaimarramsaz.ironFitness.repositories.AfiliadoRepository
import ar.madmaimarramsaz.ironFitness.repositories.PersonaRepository

class Nuevo_Afiliado_Pag4_Activity : AppCompatActivity() {
    private lateinit var personaRepository: PersonaRepository
    private lateinit var afiliadoRepository: AfiliadoRepository

    private lateinit var inputTelefono: EditText
    private lateinit var inputTelefono2: EditText
    private lateinit var btnGuardar: ImageButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_nuevo_afiliado_pag4)
        Log.d("NuevoAfiliado", "Entrando en NuevoAfiliadoActivity")


        Log.e("NuevoAfiliado", "Entrando en NuevoAfiliadoActivity")
        Log.e("nombre", intent.getStringExtra("nombre") ?: "")

        // Recopilación de información anterior desde el intent
        val esSocio = intent.getBooleanExtra("esSocio", false)
        val aptoMed = intent.getStringExtra("aptoMed") ?: ""
        val fechaAfiliacion = intent.getStringExtra("fechaAfil") ?: ""
        val nombre = intent.getStringExtra("nombre") ?: ""
        val apellido = intent.getStringExtra("apellido") ?: ""
        val dni = intent.getStringExtra("dni") ?: ""
        val fechaNacimiento = intent.getStringExtra("fechaNacimiento") ?: ""
        val direccion = intent.getStringExtra("direccion") ?: ""
        val ciudad = intent.getStringExtra("ciudad") ?: ""
        val codigoPostal = intent.getStringExtra("codigoPostal") ?: ""
        val email = intent.getStringExtra("email") ?: ""

        Log.e("nombre", intent.getStringExtra("nombre") ?: "")
        inputTelefono = findViewById(R.id.inputTelefono)
        inputTelefono2 = findViewById(R.id.inputTelefonoEmerg)
        btnGuardar = findViewById(R.id.btnGuardar)

        personaRepository = PersonaRepository(BaseDatos(this))
        afiliadoRepository = AfiliadoRepository(BaseDatos(this))

        btnGuardar.setOnClickListener {
            val telefono1 = inputTelefono.text.toString().toIntOrNull()
            val telefono2 = inputTelefono2.text.toString().toIntOrNull()

            // Crear objeto Persona con todos los datos necesarios
            val persona = Persona(
                nombre = nombre,
                apellido = apellido,
                dni = dni,
                fechaNacimiento = fechaNacimiento,
                direccion = direccion,
                localidad = ciudad,
                cp = codigoPostal,
                correoElect = email,
                telefono1 = telefono1,
                telefono2 = telefono2,
                eliminado = false
            )

            // Insertar la persona en la base de datos
            val personaId = personaRepository.createPersona(persona)
            Log.d("NuevoAfiliado", "Persona insertada con ID: $personaId")

            // Verificar si se insertó correctamente antes de proceder con el afiliado
            if (personaId > 0) {
                // Crear objeto Afiliado
                val afiliado = Afiliado(
                    esSocio = esSocio,
                    aptoMedico = aptoMed,
                    fechaAfiliacion = fechaAfiliacion,
                    personaId = personaId
                )

                // Insertar el afiliado en la base de datos
                val afiliadoId = afiliadoRepository.createAfiliado(afiliado)

                // Verificar si se insertó correctamente el afiliado
                if (afiliadoId > 0) {
                    Toast.makeText(
                        this,
                        "Persona y afiliado guardados con éxito",
                        Toast.LENGTH_LONG
                    ).show()
                    val intent = Intent(this, GestionAfiliadoActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(
                        this,
                        "Error al guardar el afiliado",
                        Toast.LENGTH_LONG
                    ).show()
                }
            } else {
                Toast.makeText(
                    this,
                    "Error al guardar la persona",
                    Toast.LENGTH_LONG
                ).show()
            }

            // Finalizar la actividad
            finish()
        }
        // Botón para volver a la ventana anterior
        val btn_volver: Button = findViewById(R.id.image_back_button)
        btn_volver.setOnClickListener {
            finish()
        }

        // Barra de navegación - Botón 1: Pagar
        val btn_pagar: Button = findViewById(R.id.image_low_menu_quad)
        btn_pagar.setOnClickListener {
            irAPagos()
        }

        // Barra de navegación - Botón 2: Ir a Home
        val btn_home: Button = findViewById(R.id.image_low_menu_quad1)
        btn_home.setOnClickListener {
            irAHome()
        }

        // Barra de navegación - Botón 3: Ir a Gestión de Afiliados
        val btn_gestionAfiliado: Button = findViewById(R.id.image_low_menu_quad2)
        btn_gestionAfiliado.setOnClickListener {
            irAGestionAfiliado()
        }
    }

    // Funciones para la barra de navegación
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


