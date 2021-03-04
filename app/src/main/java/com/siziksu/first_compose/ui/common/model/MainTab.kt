package com.siziksu.first_compose.ui.common.model

import android.os.Parcelable
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class MainTab(
    val icon: @RawValue ImageVector,
    val title: String,
    val content: @Composable () -> Unit
) : Parcelable
