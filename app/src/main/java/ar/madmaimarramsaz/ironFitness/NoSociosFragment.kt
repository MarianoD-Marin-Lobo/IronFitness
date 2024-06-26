package ar.madmaimarramsaz.ironFitness

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class NoSociosFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_todos, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view)

        // Datos hardcodeados para la tabla
        val data = listOf(
            Pair(false, "María Torres"),
            Pair(false, "Lucas Ramírez"),
            Pair(false, "Carla Suárez"),
            Pair(false, "Matías López"),
            Pair(false, "Camila Medina"),
            Pair(false, "Emilio Herrera"),
            Pair(false, "Juana Castro"),
            Pair(false, "Tomás Sánchez"),
            Pair(false, "Abril Romero"),
            Pair(false, "Ignacio Molina"),
            Pair(false, "Juliana Díaz"),
            Pair(false, "Bruno González"),
            Pair(false, "Martina Ortiz"),
            Pair(false, "Facundo Pérez"),
            Pair(false, "Catalina Fernández"),
            Pair(false, "Gastón Martínez"),
            Pair(false, "Agustina Ruiz"),
            Pair(false, "Federico Castro"),
            Pair(false, "Valeria Martínez"),
            Pair(false, "Lautaro Gómez")   // nosocio
        )
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = TableAdapter(data)

        return view
    }
}