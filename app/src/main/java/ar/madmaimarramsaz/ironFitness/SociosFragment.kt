package ar.madmaimarramsaz.ironFitness

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ar.madmaimarramsaz.ironFitness.repositories.AfiliadoRepository

class SociosFragment : Fragment() {

    private lateinit var afiliadoRepository: AfiliadoRepository

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_todos, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view)

        val db = BaseDatos(requireContext())
        afiliadoRepository = AfiliadoRepository(db)

        val socios = afiliadoRepository.getAllSocios()
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = TableAdapter(socios)

        return view
    }
}