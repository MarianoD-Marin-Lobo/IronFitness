package ar.madmaimarramsaz.ironFitness

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ar.madmaimarramsaz.ironFitness.Entidades.Afiliado

class TableAdapter(
    private val data: List<Afiliado>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<TableAdapter.TableViewHolder>()  {


        private val imagenSocioId = R.drawable.socio_icon
        private val imagenNoSocioId = R.drawable.nosocio_icon

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TableViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.tabla_item, parent, false)
        return TableViewHolder(view)
    }

    override fun onBindViewHolder(holder: TableViewHolder, position: Int) {
        val afiliado = data[position]
        val imagenId = if (afiliado.esSocio) imagenSocioId else imagenNoSocioId

        holder.imageColumn.setImageResource(imagenId)
        holder.nombreColumn.text = "${afiliado.persona.nombre} ${afiliado.persona.apellido}"
        holder.itemView.setOnClickListener {
            listener.onItemClick(position)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class TableViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageColumn: ImageView = itemView.findViewById(R.id.image_column)
        val nombreColumn: TextView = itemView.findViewById(R.id.nombre_column)
    }
}
