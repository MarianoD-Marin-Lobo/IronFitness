package ar.madmaimarramsaz.ironFitness

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SociosFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_todos, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view)

        // Datos hardcodeados para la tabla
        val data = listOf(
            Pair(true, "Juan Pérez"),
            Pair(true, "Pedro Gómez"),
            Pair(true, "María López"),
            Pair(true, "Ana Martínez"),
            Pair(true, "Luis Rodríguez"),
            Pair(true, "Laura Sánchez"),
            Pair(true, "Diego Fernández"),
            Pair(true, "Carolina González"),
            Pair(true, "Andrés Díaz"),
            Pair(true, "Elena Vázquez"),
            Pair(true, "Francisco Ruiz"),
            Pair(true, "Sofía Castro"),
            Pair(true, "Miguel Núñez"),
            Pair(true, "Isabel Molina"),
            Pair(true, "Gonzalo Ortega"),
            Pair(true, "Lucía Hernández"),
            Pair(true, "Javier Jiménez"),
            Pair(true, "Alejandra Pérez"),
            Pair(true, "Daniel Gómez"),
            Pair(true, "Valentina López")
        )
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = TableAdapter(data)

        return view
    }
}