package com.ryen.cryptotracker.crypto.presentation.models

import androidx.annotation.DrawableRes
import com.ryen.cryptotracker.crypto.domain.Coin
import com.ryen.cryptotracker.core.presentation.util.getDrawableIdForCoin
import com.ryen.cryptotracker.crypto.domain.CoinPrice
import com.ryen.cryptotracker.crypto.presentation.coin_detail.DataPoint
import java.text.NumberFormat
import java.util.Locale

data class CoinUi(
    val id: String,
    val rank: Int,
    val name: String,
    val symbol: String,
    val marketCapUsd: DisplayableNumber,
    val priceUsd: DisplayableNumber,
    val changeInPercent: DisplayableNumber,
    @DrawableRes val iconRes: Int,
    val coinPriceHistory: List<DataPoint> = emptyList()
)

data class DisplayableNumber(
    val value: Double,
    val formatted: String
)

fun Coin.toCoinUi(): CoinUi{
    return CoinUi(
        id = id,
        rank = rank,
        name = name,
        symbol = symbol,
        priceUsd = priceUsd.toDisplayableNumber(),
        marketCapUsd = marketCapUsd.toDisplayableNumber(),
        changeInPercent = changePercent24hr.toDisplayableNumber(),
        iconRes = getDrawableIdForCoin(symbol)
    )
}

fun Double.toDisplayableNumber(): DisplayableNumber {
    val formatter = NumberFormat.getNumberInstance(Locale.getDefault()).apply {
        minimumIntegerDigits = 2
        maximumIntegerDigits = 2
    }
    return DisplayableNumber(
        value = this,
        formatted = formatter.format(this)
    )
}