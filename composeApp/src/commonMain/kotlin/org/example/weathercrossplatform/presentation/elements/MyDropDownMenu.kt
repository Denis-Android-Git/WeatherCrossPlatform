package org.example.weathercrossplatform.presentation.elements

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import org.example.weathercrossplatform.presentation.settings_screen.SettingsScreenAction
import org.example.weathercrossplatform.presentation.settings_screen.SettingsScreenState
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import weathercrossplatform.composeapp.generated.resources.Res
import weathercrossplatform.composeapp.generated.resources.celc
import weathercrossplatform.composeapp.generated.resources.far

@Composable
fun MyDropDownMenu(
    onAction: (SettingsScreenAction) -> Unit,
    state: SettingsScreenState,
    expanded: Boolean,
    list: List<StringResource>,
    settingsType: SettingsType
) {
    DropdownMenu(
        expanded = expanded,
        onDismissRequest = {
            when (settingsType) {
                SettingsType.TEMPERATURE -> onAction(SettingsScreenAction.SetDropDownTempExpanded(false))
                SettingsType.WIND -> onAction(SettingsScreenAction.SetDropDownWindExpanded(false))
                SettingsType.PRESSURE -> onAction(SettingsScreenAction.SetDropDownPressureExpanded(false))
            }
        },
        containerColor = Color.Gray
    ) {
        list.forEach { res ->
            DropdownMenuItem(
                text = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = stringResource(res),
                            color = Color.White
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        if (state.isTempC && res == Res.string.celc || !state.isTempC && res == Res.string.far) {
                            Icon(
                                imageVector = Icons.Default.Check,
                                contentDescription = null,
                                tint = Color.White
                            )
                        }
                    }
                },
                onClick = {

                }
            )
        }
    }
}

@Preview
@Composable
fun MyDropDownMenuPreview() {
    MyDropDownMenu(
        {}, SettingsScreenState(),
        list = emptyList(),
        expanded = true,
        settingsType = SettingsType.TEMPERATURE
    )
}