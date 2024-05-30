package ar.madmaimarramsaz.ironFitness

import java.util.Date
import java.math.BigDecimal

data class Pago(
    val id: Int = 0,
    val PersonaID: Int,
    val FechaPago: Date,
    val Monto: BigDecimal,
    val MetodoPago: String,
    val Comentario: String?,
    val cuota: Int,
    val FechaVencimiento: Date
)