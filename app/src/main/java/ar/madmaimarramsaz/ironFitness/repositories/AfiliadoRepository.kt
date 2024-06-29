package ar.madmaimarramsaz.ironFitness.repositories

import ar.madmaimarramsaz.ironFitness.BaseDatos
import ar.madmaimarramsaz.ironFitness.Entidades.Afiliado

class AfiliadoRepository(private val database: BaseDatos) {
    fun getAfiliadoById(id: Long): Afiliado? {
        return database.getAfiliadoById(id)
    }

    fun createAfiliado(afiliado: Afiliado,personaId: Long): Long {
        return database.insertAfiliado(afiliado, personaId)
    }

    fun getAllAfiliados(): List<Afiliado> {
        return database.getAllAfiliados()
    }

    fun getAllSocios(): List<Afiliado> {
        return database.getAllSocios()
    }

    fun getAllNoSocios(): List<Afiliado> {
        return database.getAllNoSocios()
    }

    fun borrarAfiliadoYPersona(idAfiliado: Long) {
        database.borrarAfiliadoYPersona(idAfiliado)
    }


}