package org.example.weathercrossplatform.presentation.settings_screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.kashif_e.backdrop.backdrops.rememberLayerBackdrop
import org.example.weathercrossplatform.presentation.elements.LiquidToggle
import org.example.weathercrossplatform.presentation.elements.MyDropDownElement
import org.example.weathercrossplatform.presentation.elements.SettingsElement
import org.example.weathercrossplatform.presentation.elements.SettingsType
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import weathercrossplatform.composeapp.generated.resources.Res
import weathercrossplatform.composeapp.generated.resources.about_app
import weathercrossplatform.composeapp.generated.resources.liquid_glass
import weathercrossplatform.composeapp.generated.resources.liquid_glass_desc
import weathercrossplatform.composeapp.generated.resources.policy
import weathercrossplatform.composeapp.generated.resources.settings
import weathercrossplatform.composeapp.generated.resources.units

@Composable
fun SettingsScreenRoot(
    modifier: Modifier,
    viewModel: SettingsScreenViewModel = koinViewModel(),
    onBackButtonClick: () -> Unit

) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    SettingsScreenScreen(
        state = state,
        onAction = viewModel::onAction,
        onBackButtonClick = onBackButtonClick,
        modifier = modifier
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreenScreen(
    modifier: Modifier = Modifier,
    state: SettingsScreenState,
    onAction: (SettingsScreenAction) -> Unit,
    onBackButtonClick: () -> Unit
) {
    val backdrop = rememberLayerBackdrop()
    val toggle1 by rememberUpdatedState(newValue = state.isLiquidGlassOn)
    val lazyColumnState = rememberLazyListState()
    val firstVisibleItemIndex by derivedStateOf { lazyColumnState.firstVisibleItemIndex }
    val animatedAlpha by animateFloatAsState(
        if (firstVisibleItemIndex > 0) 0f else 1f
    )
    Scaffold(
        modifier = modifier,
        contentWindowInsets = WindowInsets.safeDrawing,
        containerColor = Color.Black,
        topBar = {
            Box(
                modifier = Modifier.fillMaxWidth().systemBarsPadding()
            ) {
                IconButton(
                    onClick = onBackButtonClick,
                    modifier = Modifier.align(Alignment.CenterStart)
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "back",
                        tint = Color.White
                    )
                }
                AnimatedVisibility(
                    visible = animatedAlpha == 0f,
                    modifier = Modifier.align(Alignment.Center),
                    enter = slideInVertically(
                        initialOffsetY = { it },
                    ),
                    exit = slideOutVertically(
                        targetOffsetY = { it }
                    )
                ) {
                    Text(
                        text = stringResource(Res.string.settings),
                        color = Color.White, fontSize = 24.sp
                    )
                }
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.TopCenter
        ) {
            LazyColumn(
                modifier = Modifier
                    .widthIn(max = 600.dp)
                    .fillMaxSize()
                    .padding(paddingValues)
                    .then(
                        Modifier.padding(horizontal = 8.dp)
                    ),
                state = lazyColumnState,
                contentPadding = PaddingValues(bottom = 8.dp)
            ) {
                item {
                    Spacer(modifier = Modifier.height(32.dp))
                    Text(
                        text = stringResource(Res.string.settings),
                        modifier = Modifier.padding(start = 10.dp),
                        color = Color.White, fontSize = 24.sp
                    )
                }
                item {
                    Spacer(modifier = Modifier.height(32.dp))
                    SettingsElement(
                        title = stringResource(Res.string.units)
                    ) {
                        MyDropDownElement(
                            onAction = onAction,
                            state = state,
                            settingsType = SettingsType.TEMPERATURE
                        )
                        Spacer(modifier = Modifier.height(24.dp))
                        MyDropDownElement(
                            onAction = onAction,
                            state = state,
                            settingsType = SettingsType.WIND
                        )
                        Spacer(modifier = Modifier.height(24.dp))
                        MyDropDownElement(
                            onAction = onAction,
                            state = state,
                            settingsType = SettingsType.PRESSURE
                        )
                    }
                    if (state.isLiquidGlassAvailable) {
                        Spacer(modifier = Modifier.height(32.dp))
                        SettingsElement(
                            title = stringResource(Res.string.liquid_glass)
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = stringResource(Res.string.liquid_glass_desc),
                                    modifier = Modifier.weight(1f),
                                    color = Color.White, fontSize = 16.sp
                                )
                                LiquidToggle(
                                    selected = {
                                        toggle1
                                    },
                                    onSelect = {
                                        onAction(SettingsScreenAction.SetLiquidGlass(it))
                                    },
                                    backdrop = backdrop
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(32.dp))
                    SettingsElement(
                        title = stringResource(Res.string.about_app)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth().clickable {
                                onAction(SettingsScreenAction.OpenPrivacyPolicy)
                            }
                        ) {
                            Text(
                                text = stringResource(Res.string.policy),
                                modifier = Modifier.weight(1f),
                                color = Color.White, fontSize = 16.sp
                            )
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                                contentDescription = null,
                                tint = Color.Gray
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    MaterialTheme {
        SettingsScreenScreen(
            state = SettingsScreenState(
                isLiquidGlassAvailable = true
            ),
            onAction = {},
            onBackButtonClick = {},
            modifier = Modifier
        )
    }
}
