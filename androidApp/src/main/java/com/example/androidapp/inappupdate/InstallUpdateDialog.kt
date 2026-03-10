package com.example.androidapp.inappupdate

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.example.weathercrossplatform.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InstallUpdateDialog(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    dialogTitle: String,
    dialogText: String,
    confirmButtonText: String,
    dismissButtonText: String
) {
    AlertDialog(
        title = {
            Text(text = dialogTitle, color = Color.White)
        },
        text = {
            Text(text = dialogText, color = Color.White)
        },
        onDismissRequest = {
            onDismissRequest()
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirmation()
                },
                colors = ButtonDefaults.textButtonColors(
                    contentColor = Color.White
                )
            ) {
                Text(confirmButtonText)
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    onDismissRequest()
                },
                colors = ButtonDefaults.textButtonColors(
                    contentColor = Color.White
                )
            ) {
                Text(dismissButtonText)
            }
        },
        containerColor = Color(0xFF357BD9),
        shape = RoundedCornerShape(6.dp)
    )
}

@Preview
@Composable
fun PreviewInstallUpdateDialog() {
    InstallUpdateDialog(
        onDismissRequest = {},
        onConfirmation = {},
        dialogTitle = stringResource(R.string.update_downloaded),
        dialogText = stringResource(R.string.install),
        confirmButtonText = "Confirm",
        dismissButtonText = "Dismiss",
    )
}
