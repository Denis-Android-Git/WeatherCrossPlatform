package org.example.weathercrossplatform.presentation.elements

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.weathercrossplatform.presentation.settings_screen.SettingsScreenAction
import org.example.weathercrossplatform.presentation.settings_screen.SettingsScreenState
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import weathercrossplatform.composeapp.generated.resources.Res
import weathercrossplatform.composeapp.generated.resources.celc
import weathercrossplatform.composeapp.generated.resources.expand
import weathercrossplatform.composeapp.generated.resources.far
import weathercrossplatform.composeapp.generated.resources.inrt
import weathercrossplatform.composeapp.generated.resources.kmh
import weathercrossplatform.composeapp.generated.resources.mmrt
import weathercrossplatform.composeapp.generated.resources.mph
import weathercrossplatform.composeapp.generated.resources.pressure
import weathercrossplatform.composeapp.generated.resources.temp
import weathercrossplatform.composeapp.generated.resources.wind_speed

@Composable
fun MyDropDownElement(
    onAction: (SettingsScreenAction) -> Unit,
    state: SettingsScreenState,
    settingsType: SettingsType
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = when (settingsType) {
                SettingsType.TEMPERATURE -> stringResource(Res.string.temp)
                SettingsType.WIND -> stringResource(Res.string.wind_speed)
                SettingsType.PRESSURE -> stringResource(Res.string.pressure)
            },
            color = Color.White, fontSize = 16.sp
        )
        Spacer(modifier = Modifier.weight(1f))
        Box {
            Row(
                modifier = Modifier.clickable {
                    when (settingsType) {
                        SettingsType.TEMPERATURE -> onAction(SettingsScreenAction.SetDropDownTempExpanded(true))
                        SettingsType.WIND -> onAction(SettingsScreenAction.SetDropDownWindExpanded(true))
                        SettingsType.PRESSURE -> onAction(SettingsScreenAction.SetDropDownPressureExpanded(true))
                    }
                },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = when (settingsType) {
                        SettingsType.TEMPERATURE -> if (state.isTempC) stringResource(Res.string.celc) else stringResource(Res.string.far)
                        SettingsType.WIND -> if (state.isWindKph) stringResource(Res.string.kmh) else stringResource(Res.string.mph)
                        SettingsType.PRESSURE -> if (state.isPressureMb) stringResource(Res.string.mmrt) else stringResource(Res.string.inrt)
                    },
                    modifier = Modifier.width(100.dp),
                    color = Color.Gray, fontSize = 11.sp, lineHeight = 10.sp
                )
                Icon(
                    painterResource(Res.drawable.expand),
                    modifier = Modifier.size(15.dp),
                    contentDescription = null,
                    tint = Color.Gray
                )
            }
            MyDropDownMenu(
                onAction = onAction,
                state = state,
                list = when (settingsType) {
                    SettingsType.TEMPERATURE -> listOf(Res.string.celc, Res.string.far)
                    SettingsType.WIND -> listOf(Res.string.kmh, Res.string.mph)
                    SettingsType.PRESSURE -> listOf(Res.string.mmrt, Res.string.inrt)
                },
                expanded = when (settingsType) {
                    SettingsType.TEMPERATURE -> state.isDropTempExpanded
                    SettingsType.WIND -> state.isDropWindExpanded
                    SettingsType.PRESSURE -> state.isDropPressureExpanded
                },
                settingsType = settingsType
            )
        }
    }
}

@Preview
@Composable
fun MyDropDownElementPreview() {
    MyDropDownElement(
        onAction = {},
        state = SettingsScreenState(),
        settingsType = SettingsType.PRESSURE
    )
}

enum class SettingsType {
    TEMPERATURE,
    WIND,
    PRESSURE
}