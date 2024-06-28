package ar.madmaimarramsaz.ironFitness

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
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
    private lateinit var broadcastReceiver: BroadcastReceiver
    private lateinit var adapter: TableAdapter

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
        adapter = TableAdapter(socios, this)
        recyclerView.adapter = adapter

        // Registrar el BroadcastReceiver
        broadcastReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                // Refrescar la lista de socios
                val updatedSocios = afiliadoRepository.getAllSocios()
                adapter.updateData(updatedSocios)
            }
        }
        val intentFilter = IntentFilter("afiliado_borrado")

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            requireContext().registerReceiver(broadcastReceiver, intentFilter, Context.RECEIVER_NOT_EXPORTED)
        } else {
            requireContext().registerReceiver(broadcastReceiver, intentFilter)
        }
        return view

    }
    override fun onDestroyView() {
        super.onDestroyView()
        // Desregistrar el BroadcastReceiver
        requireContext().unregisterReceiver(broadcastReceiver)
    }
    override fun onItemClick(position: Int) {
        val afiliado = afiliadoRepository.getAllSocios()[position]
        val intent = Intent(context, Datos_Afiliado_Ver::class.java).apply {
            putExtra("idAfiliado", afiliado.id)
        }
        startActivity(intent)
    }


}