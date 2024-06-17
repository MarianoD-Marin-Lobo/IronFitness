package ar.madmaimarramsaz.ironFitness

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return 3 // Número de pestañas
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> TodosFragment()
            1 -> SociosFragment()
            2 -> NoSociosFragment()
            else -> TodosFragment()
        }
    }
}
