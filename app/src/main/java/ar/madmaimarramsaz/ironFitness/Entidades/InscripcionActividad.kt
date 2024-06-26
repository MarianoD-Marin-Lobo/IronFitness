package ar.madmaimarramsaz.ironFitness.Entidades

import java.util.Date

data class InscripcionActividad (
    val InscripcionID: Int = 0,
    val NoAfiliadoID: Int? = null,
    val ActividadID: Int? = null,
    val FechaRegistro: Date? = null,
    val PagoID: Int? = null
)