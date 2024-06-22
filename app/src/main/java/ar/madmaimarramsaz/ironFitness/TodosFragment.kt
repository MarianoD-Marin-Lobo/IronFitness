package ar.madmaimarramsaz.ironFitness

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TodosFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_todos, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view)

        // Datos hardcodeados para la tabla

        val dataSocio = listOf(
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

        val dataNoSocio = listOf(
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
            Pair(false, "Lautaro Gómez")
        )
        val data = (dataSocio + dataNoSocio).shuffled()
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = TableAdapter(data)

        return view
    }
}
