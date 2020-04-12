package araikovich.inc.bekind.domain

import araikovich.inc.bekind.data.repository.TasksRepository
import araikovich.inc.bekind.data.repository.impl.FetchTaskResult
import araikovich.inc.bekind.ui.home.data.AdviceModel
import araikovich.inc.bekind.ui.home.data.MissionsListModel
import araikovich.inc.bekind.ui.home.data.SmallDeedsListModel
import java.text.SimpleDateFormat
import java.util.*

class HomeScreenFetchDataUseCase(private val repository: TasksRepository) {

    suspend fun fetchHomeScreenData(): List<Any> {
        val data = repository.fetchTasksAndMissions()
        data.advice = getAdvice(data)
        return mutableListOf(
            data.advice,
            SmallDeedsListModel(data.smallDeeds),
            MissionsListModel(data.missions)
        )
    }

    private suspend fun getAdvice(data: FetchTaskResult): AdviceModel {
        val sdf = SimpleDateFormat("yyy-MM-dd", Locale.getDefault())
        val currentAdvice = repository.getSavedAdvices().maxBy { sdf.parse(it.savedDate) }
        currentAdvice?.also {
            return if (areDateSameCurrent(it.savedDate)) {
                repository.getAdviceModel(currentAdvice)
            } else {
                repository.saveAdvice(data.advice)
                data.advice
            }
        }
        repository.saveAdvice(data.advice)
        return data.advice
    }

    private fun areDateSameCurrent(date: String): Boolean {
        val sdf = SimpleDateFormat("yyy-MM-dd", Locale.getDefault())
        val cal1 = Calendar.getInstance()
        val cal2 = Calendar.getInstance()
        cal1.time = sdf.parse(date)
        return cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR) &&
                cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)
    }

}