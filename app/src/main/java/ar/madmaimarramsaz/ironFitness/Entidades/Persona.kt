package ar.madmaimarramsaz.ironFitness.Entidades

import java.util.Date

data class Persona(
    val Id: Int = 0,
    val idRol: Int? = null,
    val nombre: String? = null,
    val apellido: String? = null,
    val tipoDoc: String? = null,
    val dni: String? = null,
    val fechaNacimiento: String? = null,
    val direccion: String? = null,
    val cp: String? = null,
    val localidad: String? = null,
    val correoElect: String? = null,
    val telefono1: Int? = null,
    val telefono2: Int? = null,
    val eliminado: Boolean = false
)