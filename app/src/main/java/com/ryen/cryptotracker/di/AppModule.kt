package com.ryen.cryptotracker.di

import io.ktor.client.engine.cio.CIO
import org.koin.dsl.module
import com.ryen.cryptotracker.core.data.networking.HttpClientFactory
import com.ryen.cryptotracker.crypto.data.networking.RemoteCoinDataSource
import com.ryen.cryptotracker.crypto.domain.CoinDataSource
import com.ryen.cryptotracker.crypto.presentation.coin_list.CoinListViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind


val appModule = module {
    single { HttpClientFactory.create(CIO.create()) }
    singleOf(::RemoteCoinDataSource).bind<CoinDataSource>()
    viewModelOf(::CoinListViewModel)
}