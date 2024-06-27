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
        Log.d("BaseDatos", "Creando base de datos y tablas...")
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
        db?.execSQL(CREATE_PERSONAS_TABLE)

        val CREATE_AFILIADOS_TABLE = ("CREATE TABLE $TABLE_AFILIADOS ("
                + "$COLUMN_AFILIADO_ID INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "$COLUMN_APTO_MEDICO TEXT,"
                + "$COLUMN_ES_SOCIO INTEGER,"
                + "$COLUMN_FECHA_AFILIACION TEXT,"
                + "$COLUMN_PERSONA_ID INTEGER,"
                + "FOREIGN KEY($COLUMN_PERSONA_ID) REFERENCES $TABLE_PERSONAS($COLUMN_ID)"
                + ")")
        db?.execSQL(CREATE_AFILIADOS_TABLE)

        Log.d("BaseDatos", "Tablas creadas correctamente: Administrador, Personas, Afiliados")

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
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_AFILIADOS")
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
        // Primero, insertar la persona asociada
        val personaId = insertPersona(afiliado.persona)

        if (personaId > 0) {
            // Luego, insertar el afiliado con la referencia a la persona insertada
            val db = this.writableDatabase
            val contentValues = ContentValues().apply {
                put(COLUMN_APTO_MEDICO, afiliado.aptoMedico)
                put(COLUMN_ES_SOCIO, if (afiliado.esSocio) 1 else 0)
                put(COLUMN_FECHA_AFILIACION, afiliado.fechaAfiliacion)
                put(COLUMN_PERSONA_ID, personaId)  // Aquí se usa el ID de la persona insertada
            }

            val id = db.insert(TABLE_AFILIADOS, null, contentValues)
            db.close()
            return id
        } else {
            // Manejar el caso donde no se pudo insertar la persona
            return -1
        }
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

    fun getAllAfiliados(): List<Afiliado> {
        val db = this.readableDatabase
        val query = """
        SELECT a.$COLUMN_AFILIADO_ID as id, 
               a.$COLUMN_APTO_MEDICO as aptoMedico, 
               a.$COLUMN_ES_SOCIO as esSocio, 
               a.$COLUMN_FECHA_AFILIACION as fechaAfiliacion, 
               a.$COLUMN_PERSONA_ID as personaId,
               p.$COLUMN_ID as personaId, 
               p.$COLUMN_ID_ROL as idRol, 
               p.$COLUMN_NOMBRE as nombre, 
               p.$COLUMN_APELLIDO as apellido, 
               p.$COLUMN_TIPO_DOC as tipoDoc, 
               p.$COLUMN_DNI as dni, 
               p.$COLUMN_FECHA_NACIMIENTO as fechaNacimiento, 
               p.$COLUMN_DIRECCION as direccion, 
               p.$COLUMN_CP as cp, 
               p.$COLUMN_LOCALIDAD as localidad, 
               p.$COLUMN_CORREO_ELECT as correoElect, 
               p.$COLUMN_TELEFONO1 as telefono1, 
               p.$COLUMN_TELEFONO2 as telefono2, 
               p.$COLUMN_ELIMINADO as eliminado 
        FROM $TABLE_AFILIADOS a 
        JOIN $TABLE_PERSONAS p ON a.$COLUMN_PERSONA_ID = p.$COLUMN_ID
    """.trimIndent()

        val cursor: Cursor = db.rawQuery(query, null)
        val allAfiliados = mutableListOf<Afiliado>()
        if (cursor.moveToFirst()) {
            do {
                val persona = Persona(
                    id = cursor.getLong(cursor.getColumnIndexOrThrow("personaId")),
                    idRol = cursor.getInt(cursor.getColumnIndexOrThrow("idRol")),
                    nombre = cursor.getString(cursor.getColumnIndexOrThrow("nombre")),
                    apellido = cursor.getString(cursor.getColumnIndexOrThrow("apellido")),
                    tipoDoc = cursor.getString(cursor.getColumnIndexOrThrow("tipoDoc")),
                    dni = cursor.getString(cursor.getColumnIndexOrThrow("dni")),
                    fechaNacimiento = cursor.getString(cursor.getColumnIndexOrThrow("fechaNacimiento")),
                    direccion = cursor.getString(cursor.getColumnIndexOrThrow("direccion")),
                    cp = cursor.getString(cursor.getColumnIndexOrThrow("cp")),
                    localidad = cursor.getString(cursor.getColumnIndexOrThrow("localidad")),
                    correoElect = cursor.getString(cursor.getColumnIndexOrThrow("correoElect")),
                    telefono1 = cursor.getString(cursor.getColumnIndexOrThrow("telefono1")),
                    telefono2 = cursor.getString(cursor.getColumnIndexOrThrow("telefono2")),
                    eliminado = cursor.getInt(cursor.getColumnIndexOrThrow("eliminado")) > 0
                )

                val afiliado = Afiliado(
                    id = cursor.getLong(cursor.getColumnIndexOrThrow("id")),
                    aptoMedico = cursor.getString(cursor.getColumnIndexOrThrow("aptoMedico")),
                    esSocio = cursor.getInt(cursor.getColumnIndexOrThrow("esSocio")) > 0,
                    fechaAfiliacion = cursor.getString(cursor.getColumnIndexOrThrow("fechaAfiliacion")),
                    personaId = cursor.getLong(cursor.getColumnIndexOrThrow("personaId")),
                    persona = persona
                )

                allAfiliados.add(afiliado)
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return allAfiliados
    }

    // Obtener todos los socios
    fun getAllSocios(): List<Afiliado> {
        val db = this.readableDatabase
        val query = """
        SELECT a.$COLUMN_AFILIADO_ID as id,
               a.$COLUMN_APTO_MEDICO as aptoMedico,
               a.$COLUMN_ES_SOCIO as esSocio,
               a.$COLUMN_FECHA_AFILIACION as fechaAfiliacion,
               a.$COLUMN_PERSONA_ID as personaId,
               p.$COLUMN_ID_ROL as idRol,
               p.$COLUMN_NOMBRE as nombre,
               p.$COLUMN_APELLIDO as apellido,
               p.$COLUMN_TIPO_DOC as tipoDoc,
               p.$COLUMN_DNI as dni,
               p.$COLUMN_FECHA_NACIMIENTO as fechaNacimiento,
               p.$COLUMN_DIRECCION as direccion,
               p.$COLUMN_CP as cp,
               p.$COLUMN_LOCALIDAD as localidad,
               p.$COLUMN_CORREO_ELECT as correoElect,
               p.$COLUMN_TELEFONO1 as telefono1,
               p.$COLUMN_TELEFONO2 as telefono2,
               p.$COLUMN_ELIMINADO as eliminado
        FROM $TABLE_AFILIADOS a
        JOIN $TABLE_PERSONAS p ON a.$COLUMN_PERSONA_ID = p.$COLUMN_ID
        WHERE a.$COLUMN_ES_SOCIO = 1
    """.trimIndent()

        val cursor: Cursor = db.rawQuery(query, null)
        val socios = mutableListOf<Afiliado>()
        if (cursor.moveToFirst()) {
            do {
                val persona = Persona(
                    id = cursor.getLong(cursor.getColumnIndexOrThrow("personaId")),
                    idRol = cursor.getInt(cursor.getColumnIndexOrThrow("idRol")),
                    nombre = cursor.getString(cursor.getColumnIndexOrThrow("nombre")),
                    apellido = cursor.getString(cursor.getColumnIndexOrThrow("apellido")),
                    tipoDoc = cursor.getString(cursor.getColumnIndexOrThrow("tipoDoc")),
                    dni = cursor.getString(cursor.getColumnIndexOrThrow("dni")),
                    fechaNacimiento = cursor.getString(cursor.getColumnIndexOrThrow("fechaNacimiento")),
                    direccion = cursor.getString(cursor.getColumnIndexOrThrow("direccion")),
                    cp = cursor.getString(cursor.getColumnIndexOrThrow("cp")),
                    localidad = cursor.getString(cursor.getColumnIndexOrThrow("localidad")),
                    correoElect = cursor.getString(cursor.getColumnIndexOrThrow("correoElect")),
                    telefono1 = cursor.getString(cursor.getColumnIndexOrThrow("telefono1")),
                    telefono2 = cursor.getString(cursor.getColumnIndexOrThrow("telefono2")),
                    eliminado = cursor.getInt(cursor.getColumnIndexOrThrow("eliminado")) > 0
                )

                val afiliado = Afiliado(
                    id = cursor.getLong(cursor.getColumnIndexOrThrow("id")),
                    aptoMedico = cursor.getString(cursor.getColumnIndexOrThrow("aptoMedico")),
                    esSocio = true, // esSocio siempre será true en este método
                    fechaAfiliacion = cursor.getString(cursor.getColumnIndexOrThrow("fechaAfiliacion")),
                    personaId = cursor.getLong(cursor.getColumnIndexOrThrow("personaId")),
                    persona = persona
                )

                socios.add(afiliado)
            } while (cursor.moveToNext())
        }
        cursor.close()
        return socios
    }

    // Obtener todos los no socios
    fun getAllNoSocios(): List<Afiliado> {
        val db = this.readableDatabase

        // Consulta SQL para obtener todos los no socios con JOIN entre afiliados y personas
        val query = """
        SELECT a.$COLUMN_AFILIADO_ID as id,
               a.$COLUMN_APTO_MEDICO as aptoMedico,
               a.$COLUMN_ES_SOCIO as esSocio,
               a.$COLUMN_FECHA_AFILIACION as fechaAfiliacion,
               a.$COLUMN_PERSONA_ID as personaId,
               p.$COLUMN_ID_ROL as idRol,
               p.$COLUMN_NOMBRE as nombre,
               p.$COLUMN_APELLIDO as apellido,
               p.$COLUMN_TIPO_DOC as tipoDoc,
               p.$COLUMN_DNI as dni,
               p.$COLUMN_FECHA_NACIMIENTO as fechaNacimiento,
               p.$COLUMN_DIRECCION as direccion,
               p.$COLUMN_CP as cp,
               p.$COLUMN_LOCALIDAD as localidad,
               p.$COLUMN_CORREO_ELECT as correoElect,
               p.$COLUMN_TELEFONO1 as telefono1,
               p.$COLUMN_TELEFONO2 as telefono2,
               p.$COLUMN_ELIMINADO as eliminado
        FROM $TABLE_AFILIADOS a
        JOIN $TABLE_PERSONAS p ON a.$COLUMN_PERSONA_ID = p.$COLUMN_ID
        WHERE a.$COLUMN_ES_SOCIO = 0
    """.trimIndent()

        val cursor = db.rawQuery(query, null)
        val noSocios = mutableListOf<Afiliado>()

        if (cursor.moveToFirst()) {
            do {
                val persona = Persona(
                    id = cursor.getLong(cursor.getColumnIndexOrThrow("personaId")),
                    idRol = cursor.getInt(cursor.getColumnIndexOrThrow("idRol")),
                    nombre = cursor.getString(cursor.getColumnIndexOrThrow("nombre")),
                    apellido = cursor.getString(cursor.getColumnIndexOrThrow("apellido")),
                    tipoDoc = cursor.getString(cursor.getColumnIndexOrThrow("tipoDoc")),
                    dni = cursor.getString(cursor.getColumnIndexOrThrow("dni")),
                    fechaNacimiento = cursor.getString(cursor.getColumnIndexOrThrow("fechaNacimiento")),
                    direccion = cursor.getString(cursor.getColumnIndexOrThrow("direccion")),
                    cp = cursor.getString(cursor.getColumnIndexOrThrow("cp")),
                    localidad = cursor.getString(cursor.getColumnIndexOrThrow("localidad")),
                    correoElect = cursor.getString(cursor.getColumnIndexOrThrow("correoElect")),
                    telefono1 = cursor.getString(cursor.getColumnIndexOrThrow("telefono1")),
                    telefono2 = cursor.getString(cursor.getColumnIndexOrThrow("telefono2")),
                    eliminado = cursor.getInt(cursor.getColumnIndexOrThrow("eliminado")) > 0
                )

                val afiliado = Afiliado(
                    id = cursor.getLong(cursor.getColumnIndexOrThrow("id")),
                    aptoMedico = cursor.getString(cursor.getColumnIndexOrThrow("aptoMedico")),
                    esSocio = false, // En getAllNoSocios siempre es no socio
                    fechaAfiliacion = cursor.getString(cursor.getColumnIndexOrThrow("fechaAfiliacion")),
                    personaId = cursor.getLong(cursor.getColumnIndexOrThrow("personaId")),
                    persona = persona
                )

                noSocios.add(afiliado)
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()

        return noSocios
    }

    fun getPersona(personaId: Long): Persona? {
        val db = this.readableDatabase

        var persona: Persona? = null

        val query = "SELECT * FROM $TABLE_PERSONAS WHERE $COLUMN_ID = ?"
        val selectionArgs = arrayOf(personaId.toString())

        val cursor = db.rawQuery(query, selectionArgs)

        if (cursor.moveToFirst()) {
            persona = Persona(
                id = cursor.getLong(cursor.getColumnIndexOrThrow(COLUMN_ID)),
                nombre = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NOMBRE)),
                apellido = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_APELLIDO)),
                tipoDoc = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TIPO_DOC)),
                dni = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_DNI)),
                fechaNacimiento = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_FECHA_NACIMIENTO)),
                direccion = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_DIRECCION)),
                cp = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CP)),
                localidad = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_LOCALIDAD)),
                correoElect = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CORREO_ELECT)),
                telefono1 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TELEFONO1)),
                telefono2 = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TELEFONO2)),
                eliminado = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ELIMINADO)) > 0
            )
        }

        cursor.close()
        return persona
    }
}




