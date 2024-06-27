package ar.madmaimarramsaz.ironFitness.repositories

import ar.madmaimarramsaz.ironFitness.BaseDatos
import ar.madmaimarramsaz.ironFitness.Entidades.Persona

class PersonaRepository (private val database: BaseDatos) {

    fun createPersona(persona: Persona): Long {
        return database.insertPersona(persona)
    }

    fun getPersona(personaId: Long): Persona? {
        return database.getPersona(personaId)

    }
}