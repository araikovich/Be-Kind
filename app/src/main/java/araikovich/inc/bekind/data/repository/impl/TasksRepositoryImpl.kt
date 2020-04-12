package araikovich.inc.bekind.data.repository.impl

import araikovich.inc.bekind.data.cached_data_sources.TasksCachedDataSource
import araikovich.inc.bekind.data.entities.AdviceEntity
import araikovich.inc.bekind.data.entities.MissionEntity
import araikovich.inc.bekind.data.entities.SmallDeedEntity
import araikovich.inc.bekind.data.local_data.AdviceLocalDataModel
import araikovich.inc.bekind.data.local_data.MissionLocalData
import araikovich.inc.bekind.data.local_data.SmallDeedLocalData
import araikovich.inc.bekind.data.local_providers.TasksLocalProvider
import araikovich.inc.bekind.data.mappers.Mapper
import araikovich.inc.bekind.data.repository.TasksRepository
import araikovich.inc.bekind.ui.home.data.AdviceModel
import araikovich.inc.bekind.ui.home.data.MissionModel
import araikovich.inc.bekind.ui.home.data.SmallDeedModel
import java.text.SimpleDateFormat
import java.util.*

class TasksRepositoryImpl(
    private val tasksLocalProvider: TasksLocalProvider,
    private val taskCachedDataSource: TasksCachedDataSource,
    private val adviceLocalDataToEntityMapper: Mapper<AdviceLocalDataModel, AdviceEntity>,
    private val adviceLocalDataToModelMapper: Mapper<AdviceLocalDataModel, AdviceModel>,
    private val adviceEntityToModelMapper: Mapper<AdviceEntity, AdviceModel>,
    private val missionEntityToModelMapper: Mapper<MissionEntity, MissionModel>,
    private val missionLocalDataToEntityMapper: Mapper<MissionLocalData, MissionEntity>,
    private val missionLocalDataToModelMapper: Mapper<MissionLocalData, MissionModel>,
    private val smallDeedLocalDataToEntityMapper: Mapper<SmallDeedLocalData, SmallDeedEntity>,
    private val smallDeedEntityToModelMapper: Mapper<SmallDeedEntity, SmallDeedModel>,
    private val smallDeedLocalDataToModelMapper: Mapper<SmallDeedLocalData, SmallDeedModel>
) : TasksRepository {

    override suspend fun fetchTasksAndMissions(): FetchTaskResult {
        return FetchTaskResult(
            getNewAdvice(),
            getSmallDeeds(),
            getMissions()
        )
    }

    override suspend fun saveAdvice(adviceModel: AdviceModel) {
        val allAdvices = tasksLocalProvider.provideAllAdvices()
        val advice = allAdvices.firstOrNull { it.id == adviceModel.id }
        advice?.also {
            val adviceEntity = adviceLocalDataToEntityMapper.map(it)
            val sdf = SimpleDateFormat("yyy-MM-dd", Locale.getDefault())
            adviceEntity.savedDate = sdf.format(Calendar.getInstance().time).toString()
            taskCachedDataSource.saveAdvice(adviceLocalDataToEntityMapper.map(it))
        }
    }

    override suspend fun getNewAdvice(): AdviceModel =
        adviceLocalDataToModelMapper.map(tasksLocalProvider.provideDayAdvice())

    override suspend fun getSavedAdvices(): List<AdviceEntity> =
        taskCachedDataSource.getAdvices()

    override suspend fun getAdviceModel(advice: AdviceEntity): AdviceModel =
        adviceEntityToModelMapper.map(advice)

    private suspend fun getSmallDeeds(): List<SmallDeedModel> {
        val localData = tasksLocalProvider.provideSmallDeedsList()
        val savedData = taskCachedDataSource.getSmallDeeds()
        val resultList = mutableListOf<SmallDeedModel>()
        localData.forEach { localItem ->
            val savedItem = savedData.firstOrNull { localItem.id == it.id }
            if (savedItem != null) {
                resultList.add(smallDeedEntityToModelMapper.map(savedItem))
            } else {
                taskCachedDataSource.saveSmallDeed(smallDeedLocalDataToEntityMapper.map(localItem))
                resultList.add(smallDeedLocalDataToModelMapper.map(localItem))
            }
        }
        return resultList
    }

    private suspend fun getMissions(): List<MissionModel> {
        val localData = tasksLocalProvider.provideMissions()
        val savedData = taskCachedDataSource.getMissions()
        val resultList = mutableListOf<MissionModel>()
        localData.forEach { localItem ->
            val savedItem = savedData.firstOrNull { localItem.id == it.id }
            if (savedItem != null) {
                resultList.add(missionEntityToModelMapper.map(savedItem))
            } else {
                taskCachedDataSource.saveMission(missionLocalDataToEntityMapper.map(localItem))
                resultList.add(missionLocalDataToModelMapper.map(localItem))
            }
        }
        return resultList
    }
}

data class FetchTaskResult(
    var advice: AdviceModel,
    val smallDeeds: List<SmallDeedModel>,
    val missions: List<MissionModel>
)