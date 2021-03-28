package com.siziksu.framework.ui.common.model

import android.os.Parcelable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize

@Parcelize
data class MainTab(
    val title: String,
    val content: Content
) : Parcelable {

    @IgnoredOnParcel var icon: ImageVector = Icons.Filled.Home
}
