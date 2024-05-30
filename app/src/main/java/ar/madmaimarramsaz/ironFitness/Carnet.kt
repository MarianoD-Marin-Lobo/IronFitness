package ar.madmaimarramsaz.ironFitness

import java.util.Date

data class Carnet (
    val nroCarnet: Long = 0,
    val idAfiliado: Int? = null,
    val expira: Date? = null
)