package ar.madmaimarramsaz.ironFitness

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ar.madmaimarramsaz.ironFitness.Ver_datos_afiliados_activity.Datos_Afiliado_Ver
import ar.madmaimarramsaz.ironFitness.repositories.AfiliadoRepository

class SociosFragment : Fragment(), TableAdapter.OnItemClickListener {

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
        recyclerView.adapter = TableAdapter(socios, this)

        return view
    }

    override fun onItemClick(position: Int) {
        val afiliado = afiliadoRepository.getAllSocios()[position]
        val intent = Intent(context, Datos_Afiliado_Ver::class.java).apply {
            putExtra("SOCIO_ID", afiliado.id)
        }
        startActivity(intent)
    }
}