package araikovich.inc.bekind.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import araikovich.inc.bekind.R
import araikovich.inc.bekind.databinding.FragmentMainBinding
import araikovich.inc.bekind.ui.menu.MainMenuNavigation
import araikovich.inc.bekind.ui.menu.MenuItem

class MainFragment: Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var lobbyMenuNavigation: MainMenuNavigation

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        binding = DataBindingUtil.bind(view)!!
        return view
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        setupMenuNavigation()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupMenuNavigation()
        openScreen(MenuItem.Home)
    }

    private fun setupMenuNavigation() {
        val lobbyMenuBinding = binding.menuView
        lobbyMenuNavigation = MainMenuNavigation(lobbyMenuBinding)
        val navGraphIds = listOf(
            R.navigation.home_nav_graph,
            R.navigation.achievements_nav_graph,
            R.navigation.profile_nav_graph
        )
        val navController = lobbyMenuNavigation.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = childFragmentManager,
            containerId = R.id.navHostFragment,
            intent = requireActivity().intent
        )

        navController.observe(viewLifecycleOwner,
            Observer {
                //TODO: if need check current nav controller
            }
        )
    }

    fun openScreen(menuItem: MenuItem) {
        lobbyMenuNavigation.openScreen(menuItem)
    }
}