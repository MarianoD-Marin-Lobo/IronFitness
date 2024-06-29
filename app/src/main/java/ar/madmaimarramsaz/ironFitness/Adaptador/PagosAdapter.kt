package ar.madmaimarramsaz.ironFitness.Adaptador

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ar.madmaimarramsaz.ironFitness.R

class PagosAdapter(private val listaDatos: List<List<String>>) : RecyclerView.Adapter<PagosAdapter.PagosViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagosViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_pago, parent, false)
        return PagosViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PagosViewHolder, position: Int) {
        val datosActuales = listaDatos[position]
        holder.bind(datosActuales)
    }

    override fun getItemCount(): Int {
        return listaDatos.size
    }

    class PagosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textViewNroAfiliado: TextView = itemView.findViewById(R.id.textViewNroAfiliado)
        private val textViewNombresApellidos: TextView = itemView.findViewById(R.id.textViewNombresApellidos)
        private val textViewNroIdentificacion: TextView = itemView.findViewById(R.id.textViewNroIdentificacion)

        fun bind(datos: List<String>) {
            textViewNroAfiliado.text = datos[0] // Primer dato es el número de afiliado
            textViewNombresApellidos.text = datos[1] // Segundo dato es el nombre y apellido
            textViewNroIdentificacion.text = datos[2] // Tercer dato es el número de identificación
        }
    }
}