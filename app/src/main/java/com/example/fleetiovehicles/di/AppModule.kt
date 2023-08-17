package com.example.fleetiovehicles.di

import com.example.fleetiovehicles.ui.detailsScreen.DetailsViewModel
import com.example.fleetiovehicles.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { MainViewModel(get()) }
    viewModel { parameters -> DetailsViewModel(get(), parameters.get())}

}