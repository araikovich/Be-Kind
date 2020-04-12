package araikovich.inc.bekind.di

import araikovich.inc.bekind.data.entities.AdviceEntity
import araikovich.inc.bekind.data.entities.MissionEntity
import araikovich.inc.bekind.data.entities.SmallDeedEntity
import araikovich.inc.bekind.data.local_data.AdviceLocalDataModel
import araikovich.inc.bekind.data.local_data.MissionLocalData
import araikovich.inc.bekind.data.local_data.SmallDeedLocalData
import araikovich.inc.bekind.data.mappers.*
import araikovich.inc.bekind.ui.home.data.AdviceModel
import araikovich.inc.bekind.ui.home.data.MissionModel
import araikovich.inc.bekind.ui.home.data.SmallDeedModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val mapperModule = module {
    factory<Mapper<AdviceEntity, AdviceModel>>(named("1")) {
        return@factory AdviceEntityToModelMapper()
    }
    factory<Mapper<AdviceLocalDataModel, AdviceEntity>>(named("2")) {
        return@factory AdviceLocalDataToEntityMapper()
    }
    factory<Mapper<AdviceLocalDataModel, AdviceModel>>(named("3")) {
        return@factory AdviceLocalDataToModelMapper()
    }
    factory<Mapper<MissionEntity, MissionModel>>(named("4")) {
        return@factory MissionEntityToModelMapper()
    }
    factory<Mapper<MissionLocalData, MissionEntity>>(named("5")) {
        return@factory MissionLocalDataToEntityMapper()
    }
    factory<Mapper<MissionLocalData, MissionModel>>(named("6")) {
        return@factory MissionLocalDataToModelMapper()
    }
    factory<Mapper<SmallDeedEntity, SmallDeedModel>>(named("7")) {
        return@factory SmallDeedEntityToModelMapper()
    }
    factory<Mapper<SmallDeedLocalData, SmallDeedEntity>>(named("8")) {
        return@factory SmallDeedLocalDataToEntityMapper()
    }
    factory<Mapper<SmallDeedLocalData, SmallDeedModel>>(named("9")) {
        return@factory SmallDeedLocalDataToModelMapper()
    }
}