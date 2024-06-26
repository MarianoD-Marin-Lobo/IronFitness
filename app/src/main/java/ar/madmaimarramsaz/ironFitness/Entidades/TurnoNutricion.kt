package ar.madmaimarramsaz.ironFitness.Entidades

import java.util.Date

data class TurnoNutricion(
    val idTurnoNutricion: Int = 0,
    val fecha: Date? = null,
    val hora: Date? = null,
    val idAfiliado: Int? = null
)