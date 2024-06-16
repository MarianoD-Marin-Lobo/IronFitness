package ar.madmaimarramsaz.ironFitness

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.graphics.drawable.GradientDrawable
import android.graphics.Color
import android.text.TextWatcher
import android.text.Editable
import android.view.View

class LoginActivity : AppCompatActivity() {
    private lateinit var baseDatos: BaseDatos
    private lateinit var inputUsuario: EditText
    private lateinit var inputClave: EditText
    private lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Inicializar bd
        baseDatos = BaseDatos(this)

        // Inicializar vistas
        inputUsuario = findViewById(R.id.inputUsuario)
        inputClave = findViewById(R.id.inputClave)
        btnLogin = findViewById(R.id.btnLogin)


        // Agrega un TextChangedListener al EditText para inputUsuario
        inputUsuario.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                actualizarColorBorde()
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                actualizarColorBorde()}
            override fun afterTextChanged(s: Editable?) {
                actualizarColorBorde()
            }
        })

        // Agrega un TextChangedListener al EditText para inputClave
        inputClave.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                actualizarColorBorde()
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                actualizarColorBorde()
            }
            override fun afterTextChanged(s: Editable?) {
                actualizarColorBorde()
            }
        })

        // Boton de iniciar sesion
        btnLogin.setOnClickListener {
            val usuario = inputUsuario.text.toString()
            val clave = inputClave.text.toString()

            // Si los input corresponden a un admin registrado, inicia sesión
            if (baseDatos.validarAdmin(usuario, clave)) {
                Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show()

                // Se abre la ventana al home
                val intent = Intent(this, Menu_PagosActivity::class.java)
                startActivity(intent)
            } else {

                // Si los inputs no son validos, muestra error
                Toast.makeText(
                    this,
                    "Nombre de usuario o contraseña incorrectos",
                    Toast.LENGTH_SHORT
                ).show()

                // los bordes de los inputs se muestran de color rojo
                val bordeInputUsuario = inputUsuario.background as GradientDrawable
                bordeInputUsuario.setStroke(5,Color.parseColor("#EE0000"))
                val bordeInputClave = inputClave.background as GradientDrawable
                bordeInputClave.setStroke(5,Color.parseColor("#EE0000"))

                // se visualiza otro mensaje de eror debajo del input contrasena:
                val msjError1 = findViewById<TextView>(R.id.credencialesError1)
                val msjError2 = findViewById<TextView>(R.id.credencialesError2)
                msjError1.visibility = View.VISIBLE
                msjError2.visibility = View.VISIBLE
            }


        }
    }
///////////
    // funcion Si los campos fueron completados, los bordes de los inputs y el boton cambian a gris oscuro

    fun actualizarColorBorde(){
        val bordeInputUsuario = inputUsuario.background as GradientDrawable
        val bordeInputClave = inputClave.background as GradientDrawable
        val msjError1 = findViewById<TextView>(R.id.credencialesError1)
        val msjError2 = findViewById<TextView>(R.id.credencialesError2)

        if (inputClave.text.toString().isNotEmpty() && inputUsuario.text.toString()
                .isNotEmpty()
        ) {
            msjError1.visibility = View.INVISIBLE
            msjError2.visibility = View.INVISIBLE
            bordeInputUsuario.setStroke(5, Color.parseColor("#656363"))
            bordeInputClave.setStroke(5, Color.parseColor("#656363"))
            btnLogin.setBackgroundResource(R.drawable.login_boton_datoscompletos)
            btnLogin.setTextColor(Color.parseColor("#FCFCFC"))
        } else {
            msjError1.visibility = View.INVISIBLE
            msjError2.visibility = View.INVISIBLE
            bordeInputUsuario.setStroke(5, Color.parseColor("#E9E1E1"))
            bordeInputClave.setStroke(5, Color.parseColor("#E9E1E1"))
            btnLogin.setBackgroundResource(R.drawable.login_boton_sindatos)
            btnLogin.setTextColor(Color.parseColor("#BCBCBC"))
        }
    }
}
