package com.example.fleetiovehicles.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.example.fleetiovehicles.R
import com.example.fleetiovehicles.ui.components.ErrorDetails
import com.example.fleetiovehicles.ui.components.VehicleCard
import com.example.fleetiovehicles.ui.theme.AppTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    private val viewModel: MainViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                AppTheme {
                    MainScreen(modifier = Modifier, viewModel = viewModel) { id ->
                        showDetails(id)
                    }
                }
            }
        }
    }


    private fun showDetails(id : Int) {
        this.activity?.findNavController(R.id.nav_host)?.navigate(R.id.DetailsScreen, bundleOf("id" to id))
    }

    @OptIn(ExperimentalGlideComposeApi::class, ExperimentalMaterialApi::class)
    @Composable
    fun MainScreen(modifier: Modifier, viewModel: MainViewModel, onItemClicked : (id : Int) -> Unit) {

        val vehicles = viewModel.getVehicles().collectAsLazyPagingItems()

        val refresh = viewModel.isRefreshing.observeAsState()

        val ptrState=
            rememberPullRefreshState(refresh.value!!, { vehicles.refresh() })

        Scaffold(
            modifier = modifier,
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = getString(R.string.app_name),
                            color = MaterialTheme.colors.onBackground
                        )
                    },
                    navigationIcon = null,
                    backgroundColor = Color.White,
                    contentColor = MaterialTheme.colors.primary,
                    elevation = 5.dp
                )
            },
            content = {
                Surface(
                    Modifier
                        .fillMaxWidth()
                        .padding(it)
                ) {
                    LazyColumn(modifier = Modifier
                        .fillMaxWidth()
                        .pullRefresh(ptrState)) {
                        items(vehicles.itemCount) { index ->
                            VehicleCard(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 8.dp, vertical = 4.dp),
                                vehicleInfo = vehicles[index]!!,
                                onItemClicked
                            )
                        }


                        when (vehicles.loadState.refresh) {
                            is LoadState.Error -> {

                                item { ErrorDetails(modifier, getString(R.string.error), getString(R.string.retry)){
                                    vehicles.retry()
                                } }

                            }
                            LoadState.Loading -> {

                                item {
                                    Column(
                                        modifier = Modifier
                                            .fillParentMaxSize(),
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        verticalArrangement = Arrangement.Center,
                                    ) {
                                        Text(
                                            modifier = Modifier
                                                .padding(8.dp),
                                            text = getString(R.string.loading)
                                        )

                                        CircularProgressIndicator(color = Color.Black)
                                    }
                                }

                            }
                            else -> {

                            }
                        }

                        when (vehicles.loadState.append) {
                            is LoadState.Error -> {
                                item {
                                    Column(
                                        modifier = Modifier
                                            .fillMaxWidth(),
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        verticalArrangement = Arrangement.Center,
                                    ) {
                                        Text(text = getString(R.string.unable_to_load), color = Color.Red)
                                        ErrorDetails(modifier, getString(R.string.error), getString(R.string.retry)){
                                            vehicles.retry()
                                        }
                                    }
                                }
                            }
                            is LoadState.Loading -> { // Pagination Loading UI
                                item {
                                    Column(
                                        modifier = Modifier
                                            .fillMaxWidth(),
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        verticalArrangement = Arrangement.Center,
                                    ) {
                                        Text(text = getString(R.string.loading))

                                        CircularProgressIndicator(color = Color.Black)
                                    }
                                }
                            }
                            else -> {}
                        }
                    }

                    PullRefreshIndicator(
                        refreshing = refresh.value!!,
                        state = ptrState
                    )
                }
            }
        )
    }


}