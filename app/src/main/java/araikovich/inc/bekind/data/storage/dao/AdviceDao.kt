package araikovich.inc.bekind.data.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import araikovich.inc.bekind.data.entities.AdviceEntity

@Dao
interface AdviceDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg items: AdviceEntity)

    @Query("SELECT * FROM advices WHERE id=:id")
    suspend fun getAdvice(id: Int): AdviceEntity?

    @Query("SELECT * FROM advices")
    suspend fun getAll(): List<AdviceEntity>

    @Query("DELETE FROM advices")
    suspend fun drop()
}