package com.siziksu.first_compose.ui.common.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import com.siziksu.first_compose.R
import com.siziksu.first_compose.ui.theme.DialogThemeOverlay
import com.siziksu.first_compose.ui.theme.DpUnit
import com.siziksu.first_compose.ui.theme.Opacity
import java.util.Locale

@Composable
fun AppAlertDialog(
    bodyText: Int,
    buttonText: Int,
    onButtonClick: () -> Unit
) {
    AppAlertDialog(stringResource(id = bodyText), stringResource(id = buttonText), onButtonClick)
}

@Composable
fun AppAlertDialog(
    bodyText: String,
    buttonText: String,
    onButtonClick: () -> Unit
) {
    DialogThemeOverlay {
        AlertDialog(
            text = {
                Text(
                    text = bodyText,
                    style = MaterialTheme.typography.body1,
                )
            },
            buttons = {
                Column {
                    Divider(
                        Modifier.padding(horizontal = DpUnit.VALUE_10),
                        color = MaterialTheme.colors.onSurface.copy(alpha = Opacity.OPACITY_0_2)
                    )
                    TextButton(
                        onClick = onButtonClick,
                        shape = RectangleShape,
                        contentPadding = PaddingValues(DpUnit.VALUE_15),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(text = buttonText.toUpperCase(Locale.getDefault()))
                    }
                }
            },
            onDismissRequest = onButtonClick
        )
    }
}

@Composable
fun ShowDialog(text: Int, onButtonClick: (Boolean, Int) -> Unit) {
    AppAlertDialog(
        bodyText = text,
        buttonText = R.string.dismiss,
        onButtonClick = { onButtonClick(false, 0) }
    )
}
