package ar.madmaimarramsaz.ironFitness

data class FichaMedica (
    val idFichaMedica: Int = 0,
    val idAfiliado: Int? = null,
    val grupoSanguineo: String? = null,
    val vacunaAntitetanica: Boolean? = null,
    val alergico: Boolean? = null,
    val alergia: Boolean? = null,
    val poseeEsguinceOLuxacion: Boolean? = null,
    val diabetes: Boolean? = null,
    val cardiopatiaCongenita: Boolean? = null,
    val cardiopatiaInfecciosa: Boolean? = null,
    val herniaInguinalOCruiral: Boolean? = null,
    val padecEnfermedadReciente: Boolean? = null,
    val enfermedadReciente: String? = null,
    val tomaMedicamentos: Boolean? = null,
    val medicamentos: String? = null,
    val indicacionesMedicasAdic: Boolean? = null,
    val poseeCoberturaDeSalud: Boolean? = null,
    val coberturaDeSalud: String? = null,
    val nroAfiliadoCoberturaSalud: Int? = null,
    val aptoActFisica: Boolean? = null
)