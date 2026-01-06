package org.example.weathercrossplatform.presentation.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.weathercrossplatform.presentation.settings_screen.SettingsScreenAction
import org.example.weathercrossplatform.presentation.settings_screen.SettingsScreenState
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import weathercrossplatform.composeapp.generated.resources.Res
import weathercrossplatform.composeapp.generated.resources.celc
import weathercrossplatform.composeapp.generated.resources.far
import weathercrossplatform.composeapp.generated.resources.inrt
import weathercrossplatform.composeapp.generated.resources.kmh
import weathercrossplatform.composeapp.generated.resources.mmrt
import weathercrossplatform.composeapp.generated.resources.mph

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
        modifier = Modifier.width(210.dp),
        containerColor = Color.Gray
    ) {
        list.forEach { res ->
            DropdownMenuItem(
                modifier = Modifier.background(
                    color =
                        when (settingsType) {
                            SettingsType.TEMPERATURE -> {
                                if (state.isTempC && res == Res.string.celc || !state.isTempC && res == Res.string.far) {
                                    Color(0xFF357BD9).copy(alpha = 0.3f)
                                } else {
                                    Color.Transparent
                                }
                            }

                            SettingsType.WIND -> {
                                if (state.isWindKph && res == Res.string.kmh || !state.isWindKph && res == Res.string.mph) {
                                    Color(0xFF357BD9).copy(alpha = 0.3f)

                                } else {
                                    Color.Transparent

                                }
                            }

                            SettingsType.PRESSURE -> {
                                if (state.isPressureMb && res == Res.string.mmrt || !state.isPressureMb && res == Res.string.inrt) {
                                    Color(0xFF357BD9).copy(alpha = 0.3f)

                                } else {
                                    Color.Transparent

                                }
                            }
                        }
                ),
                text = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = stringResource(res),
                            color = Color.White,
                            fontSize = 11.sp
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        when (settingsType) {
                            SettingsType.TEMPERATURE -> {
                                if (state.isTempC && res == Res.string.celc || !state.isTempC && res == Res.string.far) {
                                    Icon(
                                        imageVector = Icons.Default.Check,
                                        contentDescription = null,
                                        tint = Color.White,
                                        modifier = Modifier.size(16.dp)
                                    )
                                }
                            }

                            SettingsType.WIND -> {
                                if (state.isWindKph && res == Res.string.kmh || !state.isWindKph && res == Res.string.mph) {
                                    Icon(
                                        imageVector = Icons.Default.Check,
                                        contentDescription = null,
                                        tint = Color.White,
                                        modifier = Modifier.size(16.dp)
                                    )
                                }
                            }

                            SettingsType.PRESSURE -> {
                                if (state.isPressureMb && res == Res.string.mmrt || !state.isPressureMb && res == Res.string.inrt) {
                                    Icon(
                                        imageVector = Icons.Default.Check,
                                        contentDescription = null,
                                        tint = Color.White,
                                        modifier = Modifier.size(16.dp)
                                    )
                                }
                            }
                        }
                    }
                },
                onClick = {
                    when (settingsType) {
                        SettingsType.TEMPERATURE -> {
                            if (res == Res.string.celc) {
                                onAction(SettingsScreenAction.SetTempUnit(true))
                            } else {
                                onAction(SettingsScreenAction.SetTempUnit(false))
                            }
                        }

                        SettingsType.WIND -> {
                            if (res == Res.string.kmh) {
                                onAction(SettingsScreenAction.SetWindSpeedUnit(true))
                            } else {
                                onAction(SettingsScreenAction.SetWindSpeedUnit(false))
                            }
                        }

                        SettingsType.PRESSURE -> {
                            if (res == Res.string.mmrt) {
                                onAction(SettingsScreenAction.SetPressureUnit(true))
                            } else {
                                onAction(SettingsScreenAction.SetPressureUnit(false))
                            }
                        }
                    }
                }
            )
        }
    }
}

@Preview
@Composable
fun MyDropDownMenuPreview() {
    Box(modifier = Modifier.fillMaxSize()) {
        MyDropDownMenu(
            {}, SettingsScreenState(),
            list = listOf(Res.string.mmrt, Res.string.inrt),
            expanded = true,
            settingsType = SettingsType.PRESSURE
        )
    }
}