package ar.madmaimarramsaz.ironFitness

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import ar.madmaimarramsaz.ironFitness.Entidades.Administrador

const val DB_NAME = "BaseDatos"
const val DB_VERSION = 1

class BaseDatos(context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {

    override fun onCreate(db: SQLiteDatabase?) {
        // Creacion de la tabla Administrador
        val creacionTablaAdmin =
            "CREATE TABLE Administrador (idAdmin INTEGER PRIMARY KEY AUTOINCREMENT, idRol INTEGER, UsuarioAdm VARCHAR(50), PassAdm VARCHAR(40))"
        db?.execSQL(creacionTablaAdmin)

        // Registra un administrador al iniciar la base de datos
        val contenedor = ContentValues().apply {
            put("idAdmin", 1)
            put("idRol", 3)
            put("UsuarioAdm", "admin")
            put("PassAdm", "1234")
        }
        val resultado = db?.insert("Administrador", null, contenedor)
        if (resultado == -1L) {
            Log.e("BaseDatos", "Error al insertar al admin")
        } else {
            Log.d("BaseDatos", "Administrador insertado")
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        // No implementado
    }

    // Funcion de agregar administrador a la bd
    fun agregarAdmin(admin: Administrador): String {
        val db = this.writableDatabase
        val contenedor = ContentValues().apply {
            put("idAdmin", admin.idRol)
            put("idRol", admin.idRol)
            put("UsuarioAdm", admin.UsuarioAdm)
            put("PassAdm", admin.PassAdm)
        }

        val resultado = db.insert("Administrador", null, contenedor)
        return if (resultado == -1L) {
            "Falla en la carga de datos"
        } else {
            "Insert exitoso"
        }
    }

    // Valida que el administrador existe en la base de datos
    fun validarAdmin(inputUsuario: String, inputClave: String): Boolean {
        val db = readableDatabase
        val query = "SELECT * FROM Administrador WHERE UsuarioAdm = ? AND PassAdm = ?"
        val selectionArgs = arrayOf(inputUsuario, inputClave)
        val cursor: Cursor = db.rawQuery(query, selectionArgs)
        val count = cursor.count
        cursor.close()
        return count > 0
    }

}
