package ar.madmaimarramsaz.ironFitness

import java.util.Date
import java.math.BigDecimal

data class TicketPago(
    val id: Int,
    val idpago: Int,
    val fechaPago: Date?,
    val monto: BigDecimal?,
    val formaPago: String?
)