package ar.madmaimarramsaz.ironFitness.Entidades

import java.util.Date
import java.sql.Time
import java.math.BigDecimal

data class Actividades (
    val ActividadID: Int = 0,
    val Nombre: String? = null,
    val Descripcion: String? = null,
    val CupoMaximo: Int? = null,
    val FechaInicio: Date? = null,
    val FechaFin: Date? = null,
    val HoraInicio: Time? = null,
    val HoraFin: Time? = null,
    val Costo: BigDecimal? = null,
    val ProfesorID: Int? = null,
    val Equipamiento: String? = null,
    val DiasSemana: String? = null
)