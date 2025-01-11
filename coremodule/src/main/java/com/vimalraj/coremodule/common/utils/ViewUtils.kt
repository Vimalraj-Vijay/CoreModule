package com.vimalraj.coremodule.common.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vimalraj.coremodule.R

@Composable
fun CircularLoader(showLoader: Boolean, color: Color, trackColor: Color) {
    var loading by remember { mutableStateOf(false) }

    loading = showLoader

    if (!loading) return

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator(
            modifier = Modifier.width(48.dp),
            color = color,
            trackColor = trackColor,
        )
    }
}

@Composable
fun ErrorScreen(showError: Boolean) {
    var isError by remember { mutableStateOf(false) }

    isError = showError

    if (!isError) return

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .width(48.dp)
                    .height(48.dp),
                painter = painterResource(R.drawable.ic_error),
                contentDescription = "",
            )

            Text(
                stringResource(R.string.something_went_wrong_try_again_later),
                modifier = Modifier.padding(vertical = 8.dp)
            )

        }
    }
}


@Composable
fun GenericAlertDialog(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    dialogTitle: String,
    dialogText: String,
    confirmText: String = "",
    dismissText: String = "",
    icon: ImageVector?,
    iconColor: Color
) {
    AlertDialog(
        icon = {
            if (icon != null) {
                Icon(icon, contentDescription = null, tint = iconColor)
            }
        },
        title = {
            Text(text = dialogTitle, fontSize = 22.sp, fontStyle = FontStyle.Normal)
        },
        text = {
            Text(text = dialogText)
        },
        onDismissRequest = {
            onDismissRequest()
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirmation()
                }
            ) {
                Text(confirmText)
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    onDismissRequest()
                }
            ) {
                Text(dismissText)
            }
        }
    )
}