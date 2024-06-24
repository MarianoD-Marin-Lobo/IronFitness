package ar.madmaimarramsaz.ironFitness.repositories

import ar.madmaimarramsaz.ironFitness.BaseDatos
import ar.madmaimarramsaz.ironFitness.Entidades.Afiliado

class AfiliadoRepository(private val database: BaseDatos) {

    fun createAfiliado(afiliado: Afiliado): Long {
        return database.insertAfiliado(afiliado)
    }
}