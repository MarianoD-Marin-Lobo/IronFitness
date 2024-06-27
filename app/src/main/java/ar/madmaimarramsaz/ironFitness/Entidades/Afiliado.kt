package ar.madmaimarramsaz.ironFitness.Entidades

data class Afiliado(
    val id: Long=0,
    val aptoMedico:String,
    val esSocio: Boolean,
    val fechaAfiliacion: String,
    val personaId: Long,
    val persona: Persona

)

