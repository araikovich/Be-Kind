package araikovich.inc.bekind.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import araikovich.inc.bekind.R
import org.koin.androidx.viewmodel.ext.android.viewModel
import upgames.pokerup.android.presentation.viewmodel.ActionState

class HomeScreenFragment : Fragment() {

    private val viewModel: HomeScreenViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("wtf", "HomeScreenFragment")
        viewModel.homeScreenData.observe(viewLifecycleOwner, Observer {
            when (it.state) {
                ActionState.SUCCESS -> {
                    Log.d("wtf", "data -- ${it.data}")
                }
                ActionState.ERROR -> {
                }
                ActionState.LOADING -> {
                }
            }
        })
        viewModel.fetchTasks()
    }
}