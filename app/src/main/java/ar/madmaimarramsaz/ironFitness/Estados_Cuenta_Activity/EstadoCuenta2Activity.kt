package ar.madmaimarramsaz.ironFitness.Estados_Cuenta_Activity

import android.os.Build
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ar.madmaimarramsaz.ironFitness.GestionAfiliadoActivity
import ar.madmaimarramsaz.ironFitness.HomeActivity
import ar.madmaimarramsaz.ironFitness.Menu_PagosActivity
import ar.madmaimarramsaz.ironFitness.R
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import ar.madmaimarramsaz.ironFitness.BaseDatos
import ar.madmaimarramsaz.ironFitness.Adaptador.PagosAdapter


class EstadoCuenta2Activity : AppCompatActivity() {

    private lateinit var baseDatos: BaseDatos
    private lateinit var recyclerView: RecyclerView
    private lateinit var pagosAdapter: PagosAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_estado_cuenta2)

        // Obtener datos desde la base de datos
        val baseDatos = BaseDatos(this)
        val datos = baseDatos.obtenerDatosComoLista()

        // Configurar RecyclerView
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        pagosAdapter = PagosAdapter(datos)
        recyclerView.adapter = pagosAdapter

    /*
        var hoy:TextView
        hoy = findViewById(R.id.txtHoy)

        val fechaHoy: LocateDate = LocateDate,now()
        hoy.text = fechaHoy.toString()

        val gridLayoutResultado: GridLayout = findViewById(gridLayout)
        val base = Datos(contexto:this)

        //Obtener resultados de la consulta
        val resultadosConsulta: List<List<String>> = base.obtenerDatosComoLista()

        //Crear elementos de vista textview
        for (fila in resultadosConsulta) {
            val nombreApellido = fila[0] + " " + fila[1]
            val dni = fila[2]
            val nroAfiliado = fila[3]

            // Crear TextView para nombre y apellido
            val textViewNombreApellido = TextView(this)
            textViewNombreApellido.text = nombreApellido
            textViewNombreApellido.textSize = 16f
            textViewNombreApellido.setTextColor(Color.BLACK)
            textViewNombreApellido.setPadding(8, 8, 8, 8)

            // Crear TextView para DNI
            val textViewDNI = TextView(this)
            textViewDNI.text = "DNI: $dni"
            textViewDNI.textSize = 16f
            textViewDNI.setTextColor(Color.BLACK)
            textViewDNI.setPadding(8, 8, 8, 8)

            // Crear TextView para número de afiliado
            val textViewNroAfiliado = TextView(this)
            textViewNroAfiliado.text = "N° Afiliado: $nroAfiliado"
            textViewNroAfiliado.textSize = 16f
            textViewNroAfiliado.setTextColor(Color.BLACK)
            textViewNroAfiliado.setPadding(8, 8, 8, 8)

            // Agregar TextViews al GridLayout
            gridLayoutResultado.addView(textViewNombreApellido)
            gridLayoutResultado.addView(textViewDNI)
            gridLayoutResultado.addView(textViewNroAfiliado)

            // Configurar LayoutParams para cada TextView
            val params = GridLayout.LayoutParams()
            params.width = GridLayout.LayoutParams.WRAP_CONTENT
            params.height = GridLayout.LayoutParams.WRAP_CONTENT
            params.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f)

            textViewNombreApellido.layoutParams = params
            textViewDNI.layoutParams = params
            textViewNroAfiliado.layoutParams = params
        }
    }
*/

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