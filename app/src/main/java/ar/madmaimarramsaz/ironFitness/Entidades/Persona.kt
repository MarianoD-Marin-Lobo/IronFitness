package ar.madmaimarramsaz.ironFitness.Entidades

import java.util.Date

data class Persona(
    val Id: Int = 0,
    val idRol: Int? = null,
    val nombre: String? = null,
    val apellido: String? = null,
    val tipoDoc: String? = null,
    val dni: Int,
    val fechaNacimiento: Date? = null,
    val direccion: String? = null,
    val cp: Int? = null,
    val localidad: String? = null,
    val correoElect: String? = null,
    val telefono1: Int? = null,
    val telefono2: Int? = null,
    val eliminado: Boolean = false
)