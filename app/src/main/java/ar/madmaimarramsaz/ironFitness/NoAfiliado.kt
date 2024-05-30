package ar.madmaimarramsaz.ironFitness

import java.util.Date

data class NoAfiliado (
    val Id: Int = 0,
    val fechaAfiliacion: Date,
    val idPersona: Int,
    val eliminado: Boolean = false
)