package com.siziksu.first_compose.ui.common.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.Role.Tab
import com.siziksu.first_compose.ui.theme.DpUnit
import com.siziksu.first_compose.ui.theme.Opacity

@Composable
fun AppTab(
    text: String,
    icon: ImageVector,
    selected: Boolean,
    onSelected: () -> Unit
) {
    val color = MaterialTheme.colors.onSurface
    val tabTintColor by animateColorAsState(targetValue = if (selected) color else color.copy(alpha = Opacity.OPACITY_0_6))
    Row(
        modifier = Modifier
            .height(DpUnit.VALUE_56)
            .padding(DpUnit.VALUE_15)
            .animateContentSize()
            .selectable(
                selected = selected,
                onClick = onSelected,
                role = Tab
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(imageVector = icon, contentDescription = text, tint = tabTintColor)
        if (selected) {
            Spacer(Modifier.width(DpUnit.VALUE_10))
            Text(text = text, color = tabTintColor)
        }
    }
}
