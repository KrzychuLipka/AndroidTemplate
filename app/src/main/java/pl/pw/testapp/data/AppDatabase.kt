package pl.pw.testapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import pl.pw.testapp.data.dao.LocationDao
import pl.pw.testapp.data.entity.LocationEntity

@Database(
    entities = [
        LocationEntity::class,
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun locationDao(): LocationDao
}
