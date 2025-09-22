package com.ryen.cryptotracker.crypto.presentation.coin_list

import com.ryen.cryptotracker.core.domain.util.NetworkError

sealed interface CoinListEvent {
    data class Error(val error: NetworkError) : CoinListEvent
}