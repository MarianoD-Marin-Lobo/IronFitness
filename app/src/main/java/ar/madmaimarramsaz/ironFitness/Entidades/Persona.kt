package ar.madmaimarramsaz.ironFitness.Entidades

data class Persona(
    val id: Long = 0,
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
    val telefono1: String? = null,
    val telefono2: String? = null,
    val eliminado: Boolean = false
)