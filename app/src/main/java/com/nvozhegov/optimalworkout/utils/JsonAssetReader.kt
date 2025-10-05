package com.nvozhegov.optimalworkout.utils

import android.content.Context

object JsonAssetReader {
    fun readJsonAsset(
        context: Context,
        fileName: String)
    : String {
        return context.assets.open(fileName).bufferedReader().use { it.readText() }
    }
}