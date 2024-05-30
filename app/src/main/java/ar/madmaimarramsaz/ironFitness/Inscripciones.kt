package ar.madmaimarramsaz.ironFitness

import java.util.Date

data class Inscripciones (
    val InscripcionID: Int = 0,
    val AfiliadoID: Int? = null,
    val ActividadID: Int? = null,
    val FechaInscripcion: Date? = null
)