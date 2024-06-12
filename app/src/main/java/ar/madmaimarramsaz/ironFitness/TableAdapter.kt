package ar.madmaimarramsaz.ironFitness

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TableAdapter(private val data: List<Pair<Boolean, String>>) : RecyclerView.Adapter<TableAdapter.TableViewHolder>() {


        private val imagenSocioId = R.drawable.socio_icon
        private val imagenNoSocioId = R.drawable.nosocio_icon


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TableViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.tabla_item, parent, false)
        return TableViewHolder(view)
    }

    override fun onBindViewHolder(holder: TableViewHolder, position: Int) {
        val (esSocio, nombre) = data[position]

        // Selecciona la imagen según si es socio o no socio
        val imagenId =

            if (esSocio) {
            imagenSocioId
        } else imagenNoSocioId

        // Establece la imagen y el nombre en la fila de la tabla
        holder.imageColumn.setImageResource(imagenId)
        holder.nombreColumn.text = nombre.toString()

    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class TableViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageColumn: ImageView = itemView.findViewById(R.id.image_column)
        val nombreColumn: TextView = itemView.findViewById(R.id.nombre_column)
    }
}
