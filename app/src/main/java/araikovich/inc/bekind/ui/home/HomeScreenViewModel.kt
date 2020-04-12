package araikovich.inc.bekind.ui.home

//import araikovich.inc.bekind.ui.livedata.setSuccess
import araikovich.inc.bekind.ui.livedata.ActionResource
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import araikovich.inc.bekind.domain.HomeScreenFetchDataUseCase
import araikovich.inc.bekind.ui.base.BaseViewModel
import araikovich.inc.bekind.ui.livedata.setSuccess
import kotlinx.coroutines.launch

class HomeScreenViewModel(
    private val homeScreenFetchDataUseCase: HomeScreenFetchDataUseCase
) : BaseViewModel() {

    val homeScreenData = MutableLiveData<ActionResource<List<Any>>>()

    fun fetchTasks() {
        viewModelScope.launch(backgroundScope) {
            homeScreenFetchDataUseCase.fetchHomeScreenData().also {
                homeScreenData.setSuccess(it)
            }
        }
    }
}