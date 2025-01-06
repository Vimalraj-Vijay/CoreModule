package com.vimalraj.coremodule.views


import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.sp

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
