package ar.madmaimarramsaz.ironFitness

import java.util.Date

data class Afiliado (
    val Id: Int = 0,
    val fechaAfiliacion: Date? = null,
    val idPersona: Int? = null,
    val eliminado: Boolean = false
)
