package ar.madmaimarramsaz.ironFitness

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import ar.madmaimarramsaz.ironFitness.Entidades.Administrador
import ar.madmaimarramsaz.ironFitness.Entidades.Afiliado
import ar.madmaimarramsaz.ironFitness.Entidades.Persona

const val DB_NAME = "BaseDatos"
const val DB_VERSION = 1
private const val TABLE_PERSONAS = "personas"
private const val TABLE_AFILIADOS = "afiliados"

private const val COLUMN_ID = "id"
private const val COLUMN_ID_ROL = "idRol"
private const val COLUMN_NOMBRE = "nombre"
private const val COLUMN_APELLIDO = "apellido"
private const val COLUMN_TIPO_DOC = "tipoDoc"
private const val COLUMN_DNI = "dni"
private const val COLUMN_FECHA_NACIMIENTO = "fechaNacimiento"
private const val COLUMN_DIRECCION = "direccion"
private const val COLUMN_CP = "cp"
private const val COLUMN_LOCALIDAD = "localidad"
private const val COLUMN_CORREO_ELECT = "correoElect"
private const val COLUMN_TELEFONO1 = "telefono1"
private const val COLUMN_TELEFONO2 = "telefono2"
private const val COLUMN_ELIMINADO = "eliminado"

private const val COLUMN_AFILIADO_ID = "idAfiliado"
private const val COLUMN_APTO_MEDICO = "aptoMedico"
private const val COLUMN_ES_SOCIO = "esSocio"
private const val COLUMN_FECHA_AFILIACION = "fechaAfiliacion"
private const val COLUMN_PERSONA_ID = "personaId"

class BaseDatos(context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {

    override fun onCreate(db: SQLiteDatabase?) {
        // Creacion de la tabla Administrador
        val creacionTablaAdmin =
            "CREATE TABLE Administrador (idAdmin INTEGER PRIMARY KEY AUTOINCREMENT, idRol INTEGER, UsuarioAdm VARCHAR(50), PassAdm VARCHAR(40))"
        db?.execSQL(creacionTablaAdmin)

        val CREATE_PERSONAS_TABLE = ("CREATE TABLE $TABLE_PERSONAS ("
                + "$COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "$COLUMN_ID_ROL INTEGER,"
                + "$COLUMN_NOMBRE TEXT,"
                + "$COLUMN_APELLIDO TEXT,"
                + "$COLUMN_TIPO_DOC TEXT,"
                + "$COLUMN_DNI TEXT,"
                + "$COLUMN_FECHA_NACIMIENTO TEXT,"
                + "$COLUMN_DIRECCION TEXT,"
                + "$COLUMN_CP TEXT,"
                + "$COLUMN_LOCALIDAD TEXT,"
                + "$COLUMN_CORREO_ELECT TEXT,"
                + "$COLUMN_TELEFONO1 INTEGER,"
                + "$COLUMN_TELEFONO2 INTEGER,"
                + "$COLUMN_ELIMINADO INTEGER DEFAULT 0"
                + ")")

        val CREATE_AFILIADOS_TABLE = ("CREATE TABLE $TABLE_AFILIADOS ("
                + "$COLUMN_AFILIADO_ID INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "$COLUMN_APTO_MEDICO TEXT,"
                + "$COLUMN_ES_SOCIO INTEGER,"
                + "$COLUMN_FECHA_AFILIACION TEXT,"
                + "$COLUMN_PERSONA_ID INTEGER,"
                + "FOREIGN KEY($COLUMN_PERSONA_ID) REFERENCES $TABLE_PERSONAS($COLUMN_ID)"
                + ")")
        db?.execSQL(CREATE_PERSONAS_TABLE)
        db?.execSQL(CREATE_AFILIADOS_TABLE)


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
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_PERSONAS")
        onCreate(db)
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

    fun insertPersona(persona: Persona): Long {
        val db = this.writableDatabase
        val contentValues = ContentValues().apply {
            put(COLUMN_ID_ROL, persona.idRol)
            put(COLUMN_NOMBRE, persona.nombre)
            put(COLUMN_APELLIDO, persona.apellido)
            put(COLUMN_TIPO_DOC, persona.tipoDoc)
            put(COLUMN_DNI, persona.dni)
            put(COLUMN_FECHA_NACIMIENTO, persona.fechaNacimiento)
            put(COLUMN_DIRECCION, persona.direccion)
            put(COLUMN_CP, persona.cp)
            put(COLUMN_LOCALIDAD, persona.localidad)
            put(COLUMN_CORREO_ELECT, persona.correoElect)
            put(COLUMN_TELEFONO1, persona.telefono1)
            put(COLUMN_TELEFONO2, persona.telefono2)
            put(COLUMN_ELIMINADO, if (persona.eliminado) 1 else 0)
        }

        val id = db.insert(TABLE_PERSONAS, null, contentValues)
        db.close()
        return id
    }

    fun getPersonaById(id: Int): Persona? {
        // Lógica para obtener una persona por su ID
        return TODO("Provide the return value")
    }

    fun updatePersona(persona: Persona) {
        // Lógica para actualizar una persona existente en la base de datos
    }

    fun deletePersona(id: Int) {
        // Lógica para eliminar una persona de la base de datos
    }

    fun insertAfiliado(afiliado: Afiliado): Long {
        val db = this.writableDatabase
        val contentValues = ContentValues().apply {
            put(COLUMN_APTO_MEDICO, afiliado.aptoMedico)
            put(COLUMN_ES_SOCIO, if (afiliado.esSocio) 1 else 0)
            put(COLUMN_FECHA_AFILIACION, afiliado.fechaAfiliacion)
            put(COLUMN_PERSONA_ID, afiliado.personaId)
        }

        val id = db.insert(TABLE_AFILIADOS, null, contentValues)
        db.close()
        return id
    }

    fun getAfiliadoById(id: Int): Afiliado? {
        // Lógica para obtener un afiliado por su ID
        return TODO("Provide the return value")
    }

    fun updateAfiliado(afiliado: Afiliado) {
        // Lógica para actualizar un afiliado existente en la base de datos
    }

    fun deleteAfiliado(id: Int) {
        // Lógica para eliminar un afiliado de la base de datos
    }


}



