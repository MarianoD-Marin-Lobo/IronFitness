package ar.madmaimarramsaz.ironFitness.repositories

import ar.madmaimarramsaz.ironFitness.BaseDatos
import ar.madmaimarramsaz.ironFitness.Entidades.Pago

class PagoRepository (private val database: BaseDatos) {

    fun createPago(pago: Pago): Long {
        return database.insertPago(pago)
    }
}

