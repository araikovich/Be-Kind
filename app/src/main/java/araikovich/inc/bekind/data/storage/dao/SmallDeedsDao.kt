package araikovich.inc.bekind.data.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import araikovich.inc.bekind.data.entities.SmallDeedEntity

@Dao
interface SmallDeedsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg items: SmallDeedEntity)

    @Query("SELECT * FROM small_deeds WHERE id=:id")
    suspend fun getSmallDeed(id: Int): SmallDeedEntity

    @Query("SELECT * FROM small_deeds")
    suspend fun getAll(): List<SmallDeedEntity>

    @Query("DELETE FROM small_deeds")
    suspend fun drop()
}