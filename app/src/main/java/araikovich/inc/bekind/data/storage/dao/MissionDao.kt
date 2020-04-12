package araikovich.inc.bekind.data.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import araikovich.inc.bekind.data.entities.MissionEntity

@Dao
interface MissionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg items: MissionEntity)

    @Query("SELECT * FROM missions WHERE id=:id")
    suspend fun getMission(id: Int): MissionEntity

    @Query("SELECT * FROM missions")
    suspend fun getAll(): List<MissionEntity>

    @Query("DELETE FROM missions")
    suspend fun drop()
}