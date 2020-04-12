package araikovich.inc.bekind.data.repository

import araikovich.inc.bekind.data.entities.AdviceEntity
import araikovich.inc.bekind.data.repository.impl.FetchTaskResult
import araikovich.inc.bekind.ui.home.data.AdviceModel

interface TasksRepository {

    suspend fun fetchTasksAndMissions(): FetchTaskResult

    suspend fun saveAdvice(adviceModel: AdviceModel)

    suspend fun getNewAdvice(): AdviceModel

    suspend fun getSavedAdvices(): List<AdviceEntity>

    suspend fun getAdviceModel(advice: AdviceEntity): AdviceModel
}