package com.ryen.cryptotracker.crypto.presentation

import androidx.compose.runtime.Immutable
import com.ryen.cryptotracker.crypto.presentation.models.CoinUi

@Immutable
data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<CoinUi> = emptyList(),
    val selectedCoin: CoinUi? = null
)
