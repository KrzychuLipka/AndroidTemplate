package pl.pw.testapp.ui.dashboard

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import pl.pw.testapp.data.entity.LocationEntity

@Composable
fun LocationListScreen(
    viewModel: DashboardViewModel = hiltViewModel()
) {
    val locations: List<LocationEntity> by viewModel
        .locations
        .collectAsState(initial = emptyList())

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    viewModel.saveRandomLocation()
                }) {
                Icon(Icons.Filled.Add, contentDescription = "Save random location")
            }
        }
    ) { paddingValues ->
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)) {
            LazyColumn {
                items(locations) { location ->
                    Text("Latitude: ${location.latitude}, Longitude: ${location.longitude}")
                }
            }
        }
    }
}
