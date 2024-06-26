package ar.madmaimarramsaz.ironFitness.repositories

import ar.madmaimarramsaz.ironFitness.BaseDatos
import ar.madmaimarramsaz.ironFitness.Entidades.Afiliado

class AfiliadoRepository(private val database: BaseDatos) {

    fun createAfiliado(afiliado: Afiliado): Long {
        return database.insertAfiliado(afiliado)
    }

    fun getAllAfiliados(): List<Triple<Boolean, String, String>> {
        return database.getAllAfiliados()
    }

    fun getAllSocios(): List<Triple<Boolean, String, String>> {
        return database.getAllSocios()
    }

    fun getAllNoSocios(): List<Triple<Boolean, String, String>> {
        return database.getAllNoSocios()
    }
}