package ar.madmaimarramsaz.ironFitness

import java.util.Date

data class InformacionFinanciera (
    val Id: Int = 0,
    val personaId: Int? = null,
    val NumeroTarjetaCredito: String,
    val FechaExpiracion: Date,
    val CodigoSeguridad: Int,
    val pagoId: Int? = null
)