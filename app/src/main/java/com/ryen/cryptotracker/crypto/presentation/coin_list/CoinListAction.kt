package com.ryen.cryptotracker.crypto.presentation.coin_list

import com.ryen.cryptotracker.crypto.presentation.models.CoinUi

sealed interface CoinListAction {
    data class OnCoinClicked(val coinUi: CoinUi) : CoinListAction
}