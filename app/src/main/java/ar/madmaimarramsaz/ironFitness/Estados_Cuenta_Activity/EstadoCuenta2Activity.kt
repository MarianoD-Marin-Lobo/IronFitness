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