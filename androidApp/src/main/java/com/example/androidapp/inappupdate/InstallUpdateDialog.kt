package com.example.androidapp.inappupdate

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

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
            Text(text = dialogTitle)
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
                Text(confirmButtonText)
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    onDismissRequest()
                }
            ) {
                Text(dismissButtonText)
            }
        }
    )
}

@Preview
@Composable
fun PreviewInstallUpdateDialog() {
    InstallUpdateDialog(
        onDismissRequest = {},
        onConfirmation = {},
        dialogTitle = " Title",
        dialogText = "Text",
        confirmButtonText = "Confirm",
        dismissButtonText = "Dismiss",
    )
}