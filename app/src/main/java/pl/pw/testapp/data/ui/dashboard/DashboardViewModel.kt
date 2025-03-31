package pl.pw.testapp.data.ui.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import pl.pw.testapp.data.dao.LocationDao
import pl.pw.testapp.data.entity.LocationEntity
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val locationDao: LocationDao
) : ViewModel() {

    val locations: Flow<List<LocationEntity>> = locationDao.getAll()

    fun saveRandomLocation() {
        viewModelScope.launch {
            locationDao.save(
                LocationEntity(
                    latitude = Random.nextDouble(-90.0, 90.0),
                    longitude = Random.nextDouble(-180.0, 180.0)
                )
            )
        }
    }
}
