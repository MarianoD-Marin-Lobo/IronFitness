package ar.madmaimarramsaz.ironFitness.Entidades

import java.util.Date
import java.math.BigDecimal

data class Pago(
    val id: Int = 0,
    val nombresApellidos: String,
    val nroIdentificacion: String,
    val tipoIdentificacion: String,
    val nroAfiliado: String,
    val tipoCuota: String,
    val comentarioEquipamiento: String,
    val fechaPago: String,
    val importeAPagar: String,
    val modalidadDePago: String
)