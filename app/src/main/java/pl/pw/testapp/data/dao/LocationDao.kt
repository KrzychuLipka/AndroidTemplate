package pl.pw.testapp.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import pl.pw.testapp.data.entity.LocationEntity

@Dao
interface LocationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(
        location: LocationEntity
    )

    @Query("SELECT * FROM locations")
    fun getAll(): Flow<List<LocationEntity>>
}
